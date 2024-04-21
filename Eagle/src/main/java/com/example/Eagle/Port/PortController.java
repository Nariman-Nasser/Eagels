package com.example.Eagle.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/Port")
@CrossOrigin(origins = "*")
public class PortController {

    private final  PortService portService;

    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping
    public List<Port> GetPort(){
        return portService.GetPort();
    }


    @PostMapping
    public  void AddNewPort(@RequestBody Port port)
    {
        portService.addPort(port);
    }

    @DeleteMapping(path = "del/{portid}")
    public  void deletport (@PathVariable ("portid") long   portid )
    {
        portService.deletport( portid);

    }

    @GetMapping( path = "/search/{substring}")
    public List<Port>getPortsSTartWith( @PathVariable String substring) {
        return portService.GetPortBYSubstring(substring);
    }
}
