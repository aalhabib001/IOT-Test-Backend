package xyz.fahimrahman.iottest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.fahimrahman.iottest.model.SwitchOnOffModel;

import java.util.Optional;

@Repository
public interface SwitchOnOffRepository extends JpaRepository<SwitchOnOffModel, String> {
    Optional<SwitchOnOffModel> findByDeviceId(String deviceId);

}
