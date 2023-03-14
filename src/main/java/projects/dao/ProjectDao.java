package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import provided.DaoBase;
import projects.entity.Project;
import projects.exception.DbException;

@SuppressWarnings("unused")
public class ProjectDao extends DaoBase {
    private static final String PROJECT_TABLE = "project";

    public Project insertProject(Project project) {
        String sql = "INSERT INTO " + PROJECT_TABLE + " "
                + "(project_name, estimated_hours, actual_hours, difficulty, notes)"
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection()) {
            startTransaction(conn);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, project.getProjectName());
                stmt.setBigDecimal(2, project.getEstimatedHours());
                stmt.setBigDecimal(3, project.getActualHours());
                stmt.setInt(4, project.getDifficulty());
                stmt.setString(5, project.getNotes());

                stmt.executeUpdate();

                Integer projectId = getLastInsertId(conn, PROJECT_TABLE);
                commitTransaction(conn);

                project.setProjectId(projectId);
                return project;
            } catch (SQLException e) {
                rollbackTransaction(conn);
                throw new DbException(e);
            }
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }
}

