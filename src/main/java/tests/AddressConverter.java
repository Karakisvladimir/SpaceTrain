package tests;

import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class AddressConverter implements AttributeConverter<List<String>, String> {

        public AddressConverter () {
            System.out.println("NEW CONVERTER CREATED");
        }

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return new Gson().toJson(attribute);
    }

    @Override
        public List<String> convertToEntityAttribute (String dbData){
            System.out.println("dbData = " + dbData);
            return new Gson().fromJson(dbData, List.class);
    }
    }
