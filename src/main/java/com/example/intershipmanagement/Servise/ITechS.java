package com.example.intershipmanagement.Servise;

import com.example.intershipmanagement.entities.OffresStages;
import com.example.intershipmanagement.entities.Technologies;

import java.util.List;

public interface ITechS {
    Technologies ajouterITechS(Technologies tech);
    Technologies updateITechS(Technologies tech);
    Technologies getITechSById(long id);
    List<Technologies> getAllITechS();
    void deleteITechS(long id);
}
