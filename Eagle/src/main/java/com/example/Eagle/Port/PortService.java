package com.example.Eagle.Port;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortService {

    private  final PortRepository PortRepository;

    @Autowired
    public PortService(PortRepository portRepository) {
        PortRepository = portRepository;
    }



    public List<Port> GetPortBYSubstring(String substr){
        return PortRepository.findByportnameIgnoreCaseStartingWith(substr);
    }
    public List<Port> GetPort(){
        return PortRepository.findAll();
    }

    public  void deletport(long  portid )
    {
        boolean exists = PortRepository.existsById(portid);
        if(!exists){
            throw new IllegalStateException("port not found");
        }
        else
            PortRepository.deleteById(portid);
    }

    public  void addPort(Port port){

           port.setPortname(port.getPortname().toUpperCase());
           port.setPortcountry(port.getPortcountry().toUpperCase());
            PortRepository.save(port);


    }


}
