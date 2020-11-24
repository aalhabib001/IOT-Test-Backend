package xyz.fahimrahman.iottest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.fahimrahman.iottest.dto.request.OnOffSwitchRequest;
import xyz.fahimrahman.iottest.service.SwitchService;

@AllArgsConstructor
@RestController
@RequestMapping("")
public class SwitchController {
    private final SwitchService switchService;

    @GetMapping("/switch")
    public ResponseEntity<Object> switchCheck(@RequestParam String deviceId){
        return switchService.switchCheck(deviceId);
    }

    @PutMapping("/switch")
    public ResponseEntity<String> switchOnOff(@RequestParam String deviceId, @RequestBody OnOffSwitchRequest onOffSwitchRequest){
        return switchService.switchOnOff(deviceId,onOffSwitchRequest);
    }

    @PostMapping("/device/register")
    public ResponseEntity<String> deviceRegister(@RequestParam String deviceId){
        return switchService.deviceRegister(deviceId);
    }

}
