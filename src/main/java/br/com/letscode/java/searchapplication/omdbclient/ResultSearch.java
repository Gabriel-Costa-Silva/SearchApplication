package br.com.letscode.java.searchapplication.omdbclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultSearch {

    @JsonProperty("Search")
    private List<MovieMinimal> resultList;
    private Integer total;
    private Boolean response;

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = Boolean.valueOf(response);
    }

    @JsonProperty("totalResults")
    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }
}
