package xyz.fahimrahman.iottest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "switchonoff")
public class SwitchOnOffModel {

    @Id
    String id;

    String deviceId;

    boolean switch1;

    boolean switch2;

    boolean switch3;
}
