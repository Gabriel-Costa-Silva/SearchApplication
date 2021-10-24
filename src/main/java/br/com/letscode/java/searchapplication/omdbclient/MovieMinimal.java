package br.com.letscode.java.searchapplication.omdbclient;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("rawtypes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MovieMinimal {

    @JsonProperty("imdbID")
    private String imdbId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private Integer year;


    public void setYear(String year) {
        this.year = convertYear(year);
    }

    private int convertYear(final String year) {
        if (year.matches("\\d+")) {
            return Integer.parseInt(year);
        }
        return Arrays.stream(year.split("\\D"))
                .map(Integer::parseInt)
                .findFirst()
                .orElseThrow();
    }
    public List readCSV( )throws IOException {
        Reader leitor = Files.newBufferedReader(Paths.get("cache.csv"));
        CsvToBean csvToBean =  new CsvToBeanBuilder(leitor)
                .withType(MovieMinimal.class)
                .build();
        return csvToBean.parse();
    }



    }

}