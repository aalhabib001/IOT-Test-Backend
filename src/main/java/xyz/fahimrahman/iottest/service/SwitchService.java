package xyz.fahimrahman.iottest.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.fahimrahman.iottest.Repository.SwitchOnOffRepository;
import xyz.fahimrahman.iottest.dto.request.OnOffSwitchRequest;
import xyz.fahimrahman.iottest.dto.response.OnOffSwitchResponse;
import xyz.fahimrahman.iottest.model.SwitchOnOffModel;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class SwitchService {

    private final SwitchOnOffRepository switchOnOffRepository;
    public ResponseEntity<Object> switchCheck(String deviceId) {
        Optional<SwitchOnOffModel> switchOnOffModelOptional = switchOnOffRepository.findByDeviceId(deviceId);

        if(switchOnOffModelOptional.isPresent()){
            SwitchOnOffModel switchOnOffModel = switchOnOffModelOptional.get();

            OnOffSwitchResponse onOffSwitchResponse = new OnOffSwitchResponse();
            onOffSwitchResponse.setSwitch1(switchOnOffModel.isSwitch1());
            onOffSwitchResponse.setSwitch2(switchOnOffModel.isSwitch2());
            onOffSwitchResponse.setSwitch3(switchOnOffModel.isSwitch3());

            return new ResponseEntity<>(onOffSwitchResponse, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No Device Found with id: "+deviceId, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> switchOnOff(String deviceId, OnOffSwitchRequest onOffSwitchRequest) {
        Optional<SwitchOnOffModel> switchOnOffModelOptional = switchOnOffRepository.findByDeviceId(deviceId);

        if(switchOnOffModelOptional.isPresent()){
            SwitchOnOffModel switchOnOffModel = switchOnOffModelOptional.get();

            switchOnOffModel.setSwitch1(onOffSwitchRequest.isSwitch1());
            switchOnOffModel.setSwitch2(onOffSwitchRequest.isSwitch2());
            switchOnOffModel.setSwitch3(onOffSwitchRequest.isSwitch3());

            switchOnOffRepository.save(switchOnOffModel);

            return new ResponseEntity<>("Data Saved", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No Device Found with id: "+deviceId, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deviceRegister(String deviceId) {
        if(switchOnOffRepository.findByDeviceId(deviceId).isPresent()){
            return new ResponseEntity<>("Device Id Already Exits. Please Change Id", HttpStatus.BAD_REQUEST);
        }

        SwitchOnOffModel switchOnOffModel = new SwitchOnOffModel();
        switchOnOffModel.setId(UUID.randomUUID().toString());
        switchOnOffModel.setDeviceId(deviceId);
        switchOnOffModel.setSwitch1(false);
        switchOnOffModel.setSwitch2(false);
        switchOnOffModel.setSwitch3(false);

        switchOnOffRepository.save(switchOnOffModel);

        return new ResponseEntity<>("Device Registered.", HttpStatus.CREATED);

    }
}
