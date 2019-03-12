
package eta.oz.monica_api.v1.dto.out;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "raw",
    "temp",
    "hum",
    "co",
    "socket2B",
    "value2B",
    "no2",
    "perc",
    "loc",
    "ID",
    "time",
    "date"
})
public class SessionDTO implements Serializable
{

    @JsonProperty("raw")
    private Raw raw;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("hum")
    private Double hum;
    @JsonProperty("co")
    private Double co;
    @JsonProperty("socket2B")
    private String socket2B;
    @JsonProperty("value2B")
    private Double value2B;
    @JsonProperty("no2")
    private Integer no2;
    @JsonProperty("perc")
    private Double perc;
    @JsonProperty("loc")
    private Loc loc;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -194465561174274602L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SessionDTO() {
    }

    /**
     * 
     * @param raw
     * @param time
     * @param co
     * @param hum
     * @param no2
     * @param socket2B
     * @param loc
     * @param temp
     * @param perc
     * @param date
     * @param iD
     * @param value2B
     */
    public SessionDTO(Raw raw, Double temp, Double hum, Double co, String socket2B, Double value2B, Integer no2, Double perc, Loc loc, String iD, Integer time, String date) {
        super();
        this.raw = raw;
        this.temp = temp;
        this.hum = hum;
        this.co = co;
        this.socket2B = socket2B;
        this.value2B = value2B;
        this.no2 = no2;
        this.perc = perc;
        this.loc = loc;
        this.iD = iD;
        this.time = time;
        this.date = date;
    }

    @JsonProperty("raw")
    public Raw getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public SessionDTO withRaw(Raw raw) {
        this.raw = raw;
        return this;
    }

    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public SessionDTO withTemp(Double temp) {
        this.temp = temp;
        return this;
    }

    @JsonProperty("hum")
    public Double getHum() {
        return hum;
    }

    @JsonProperty("hum")
    public void setHum(Double hum) {
        this.hum = hum;
    }

    public SessionDTO withHum(Double hum) {
        this.hum = hum;
        return this;
    }

    @JsonProperty("co")
    public Double getCo() {
        return co;
    }

    @JsonProperty("co")
    public void setCo(Double co) {
        this.co = co;
    }

    public SessionDTO withCo(Double co) {
        this.co = co;
        return this;
    }

    @JsonProperty("socket2B")
    public String getSocket2B() {
        return socket2B;
    }

    @JsonProperty("socket2B")
    public void setSocket2B(String socket2B) {
        this.socket2B = socket2B;
    }

    public SessionDTO withSocket2B(String socket2B) {
        this.socket2B = socket2B;
        return this;
    }

    @JsonProperty("value2B")
    public Double getValue2B() {
        return value2B;
    }

    @JsonProperty("value2B")
    public void setValue2B(Double value2B) {
        this.value2B = value2B;
    }

    public SessionDTO withValue2B(Double value2B) {
        this.value2B = value2B;
        return this;
    }

    @JsonProperty("no2")
    public Integer getNo2() {
        return no2;
    }

    @JsonProperty("no2")
    public void setNo2(Integer no2) {
        this.no2 = no2;
    }

    public SessionDTO withNo2(Integer no2) {
        this.no2 = no2;
        return this;
    }

    @JsonProperty("perc")
    public Double getPerc() {
        return perc;
    }

    @JsonProperty("perc")
    public void setPerc(Double perc) {
        this.perc = perc;
    }

    public SessionDTO withPerc(Double perc) {
        this.perc = perc;
        return this;
    }

    @JsonProperty("loc")
    public Loc getLoc() {
        return loc;
    }

    @JsonProperty("loc")
    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    public SessionDTO withLoc(Loc loc) {
        this.loc = loc;
        return this;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    public SessionDTO withID(String iD) {
        this.iD = iD;
        return this;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    public SessionDTO withTime(Integer time) {
        this.time = time;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public SessionDTO withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SessionDTO withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("raw", raw).append("temp", temp).append("hum", hum).append("co", co).append("socket2B", socket2B).append("value2B", value2B).append("no2", no2).append("perc", perc).append("loc", loc).append("iD", iD).append("time", time).append("date", date).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(raw).append(hum).append(loc).append(date).append(iD).append(time).append(co).append(additionalProperties).append(no2).append(socket2B).append(temp).append(perc).append(value2B).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SessionDTO) == false) {
            return false;
        }
        SessionDTO rhs = ((SessionDTO) other);
        return new EqualsBuilder().append(raw, rhs.raw).append(hum, rhs.hum).append(loc, rhs.loc).append(date, rhs.date).append(iD, rhs.iD).append(time, rhs.time).append(co, rhs.co).append(additionalProperties, rhs.additionalProperties).append(no2, rhs.no2).append(socket2B, rhs.socket2B).append(temp, rhs.temp).append(perc, rhs.perc).append(value2B, rhs.value2B).isEquals();
    }

}
