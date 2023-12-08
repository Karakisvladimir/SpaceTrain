package passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO расшифровывается как Data Access Object, что означает объект доступа к данным.
// Он представляет собой шаблон проектирования, который отвечает за обработку операций
// с базой данных и предоставляет интерфейс для доступа к данным без необходимости
// раскрытия деталей реализации базы данных.
public class PassengerDao implements IPassengerDaoService {
    private PreparedStatement createSt;
    private PreparedStatement getByPassportSt;

    public PassengerDao(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO passenger (passport, name) VALUES(?, ?)");
        getByPassportSt = connection.prepareStatement("SELECT id, name FROM passenger WHERE passport = ?");
    }

    public void create(Passenger passenger) throws SQLException {
        createSt.setString(1, passenger.getPassport());
        createSt.setString(2, passenger.getName());
        createSt.executeUpdate();
    }

    public Passenger getByPassport(String passport) throws SQLException {
        getByPassportSt.setString(1, passport);

        try(ResultSet rs = getByPassportSt.executeQuery()) {
            if (!rs.next()) {
                return null;
            }

            Passenger result = new Passenger();
            result.setId(rs.getLong("id"));
            result.setName(rs.getString("name"));
            result.setPassport(passport);

            return result;
        }
    }
}