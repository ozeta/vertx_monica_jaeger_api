
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
    "AE_CO_zero",
    "AE_NO2",
    "crc",
    "NO2_num",
    "batteryLevel",
    "hum_num",
    "raw_ppb_O3+NO2",
    "raw_ppb_NO2",
    "WE_CO_zero",
    "WE_NO2",
    "O3_num",
    "WE_NO2_zero",
    "raw_ppm_CO",
    "AE_O3+NO2",
    "AFE",
    "temp_num",
    "WE_O3+NO2",
    "AE_NO2_zero",
    "WE_O3+NO2_zero",
    "AE_CO",
    "WE_CO",
    "AE_O3+NO2_zero",
    "socket2AB",
    "CO_num"
})
public class Raw implements Serializable
{

    @JsonProperty("AE_CO_zero")
    private String aECOZero;
    @JsonProperty("AE_NO2")
    private String aENO2;
    @JsonProperty("crc")
    private String crc;
    @JsonProperty("NO2_num")
    private String nO2Num;
    @JsonProperty("batteryLevel")
    private String batteryLevel;
    @JsonProperty("hum_num")
    private String humNum;
    @JsonProperty("raw_ppb_O3+NO2")
    private String rawPpbO3NO2;
    @JsonProperty("raw_ppb_NO2")
    private String rawPpbNO2;
    @JsonProperty("WE_CO_zero")
    private String wECOZero;
    @JsonProperty("WE_NO2")
    private String wENO2;
    @JsonProperty("O3_num")
    private String o3Num;
    @JsonProperty("WE_NO2_zero")
    private String wENO2Zero;
    @JsonProperty("raw_ppm_CO")
    private String rawPpmCO;
    @JsonProperty("AE_O3+NO2")
    private String aEO3NO2;
    @JsonProperty("AFE")
    private String aFE;
    @JsonProperty("temp_num")
    private String tempNum;
    @JsonProperty("WE_O3+NO2")
    private String wEO3NO2;
    @JsonProperty("AE_NO2_zero")
    private String aENO2Zero;
    @JsonProperty("WE_O3+NO2_zero")
    private String wEO3NO2Zero;
    @JsonProperty("AE_CO")
    private String aECO;
    @JsonProperty("WE_CO")
    private String wECO;
    @JsonProperty("AE_O3+NO2_zero")
    private String aEO3NO2Zero;
    @JsonProperty("socket2AB")
    private String socket2AB;
    @JsonProperty("CO_num")
    private String cONum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2450352460764814403L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Raw() {
    }

    /**
     * 
     * @param wENO2
     * @param wECO
     * @param aEO3NO2Zero
     * @param wEO3NO2
     * @param aEO3NO2
     * @param rawPpmCO
     * @param wECOZero
     * @param o3Num
     * @param rawPpbO3NO2
     * @param cONum
     * @param wEO3NO2Zero
     * @param aFE
     * @param crc
     * @param tempNum
     * @param batteryLevel
     * @param wENO2Zero
     * @param aECO
     * @param aENO2Zero
     * @param aECOZero
     * @param aENO2
     * @param rawPpbNO2
     * @param socket2AB
     * @param humNum
     * @param nO2Num
     */
    public Raw(String aECOZero, String aENO2, String crc, String nO2Num, String batteryLevel, String humNum, String rawPpbO3NO2, String rawPpbNO2, String wECOZero, String wENO2, String o3Num, String wENO2Zero, String rawPpmCO, String aEO3NO2, String aFE, String tempNum, String wEO3NO2, String aENO2Zero, String wEO3NO2Zero, String aECO, String wECO, String aEO3NO2Zero, String socket2AB, String cONum) {
        super();
        this.aECOZero = aECOZero;
        this.aENO2 = aENO2;
        this.crc = crc;
        this.nO2Num = nO2Num;
        this.batteryLevel = batteryLevel;
        this.humNum = humNum;
        this.rawPpbO3NO2 = rawPpbO3NO2;
        this.rawPpbNO2 = rawPpbNO2;
        this.wECOZero = wECOZero;
        this.wENO2 = wENO2;
        this.o3Num = o3Num;
        this.wENO2Zero = wENO2Zero;
        this.rawPpmCO = rawPpmCO;
        this.aEO3NO2 = aEO3NO2;
        this.aFE = aFE;
        this.tempNum = tempNum;
        this.wEO3NO2 = wEO3NO2;
        this.aENO2Zero = aENO2Zero;
        this.wEO3NO2Zero = wEO3NO2Zero;
        this.aECO = aECO;
        this.wECO = wECO;
        this.aEO3NO2Zero = aEO3NO2Zero;
        this.socket2AB = socket2AB;
        this.cONum = cONum;
    }

    @JsonProperty("AE_CO_zero")
    public String getAECOZero() {
        return aECOZero;
    }

    @JsonProperty("AE_CO_zero")
    public void setAECOZero(String aECOZero) {
        this.aECOZero = aECOZero;
    }

    public Raw withAECOZero(String aECOZero) {
        this.aECOZero = aECOZero;
        return this;
    }

    @JsonProperty("AE_NO2")
    public String getAENO2() {
        return aENO2;
    }

    @JsonProperty("AE_NO2")
    public void setAENO2(String aENO2) {
        this.aENO2 = aENO2;
    }

    public Raw withAENO2(String aENO2) {
        this.aENO2 = aENO2;
        return this;
    }

    @JsonProperty("crc")
    public String getCrc() {
        return crc;
    }

    @JsonProperty("crc")
    public void setCrc(String crc) {
        this.crc = crc;
    }

    public Raw withCrc(String crc) {
        this.crc = crc;
        return this;
    }

    @JsonProperty("NO2_num")
    public String getNO2Num() {
        return nO2Num;
    }

    @JsonProperty("NO2_num")
    public void setNO2Num(String nO2Num) {
        this.nO2Num = nO2Num;
    }

    public Raw withNO2Num(String nO2Num) {
        this.nO2Num = nO2Num;
        return this;
    }

    @JsonProperty("batteryLevel")
    public String getBatteryLevel() {
        return batteryLevel;
    }

    @JsonProperty("batteryLevel")
    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Raw withBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
        return this;
    }

    @JsonProperty("hum_num")
    public String getHumNum() {
        return humNum;
    }

    @JsonProperty("hum_num")
    public void setHumNum(String humNum) {
        this.humNum = humNum;
    }

    public Raw withHumNum(String humNum) {
        this.humNum = humNum;
        return this;
    }

    @JsonProperty("raw_ppb_O3+NO2")
    public String getRawPpbO3NO2() {
        return rawPpbO3NO2;
    }

    @JsonProperty("raw_ppb_O3+NO2")
    public void setRawPpbO3NO2(String rawPpbO3NO2) {
        this.rawPpbO3NO2 = rawPpbO3NO2;
    }

    public Raw withRawPpbO3NO2(String rawPpbO3NO2) {
        this.rawPpbO3NO2 = rawPpbO3NO2;
        return this;
    }

    @JsonProperty("raw_ppb_NO2")
    public String getRawPpbNO2() {
        return rawPpbNO2;
    }

    @JsonProperty("raw_ppb_NO2")
    public void setRawPpbNO2(String rawPpbNO2) {
        this.rawPpbNO2 = rawPpbNO2;
    }

    public Raw withRawPpbNO2(String rawPpbNO2) {
        this.rawPpbNO2 = rawPpbNO2;
        return this;
    }

    @JsonProperty("WE_CO_zero")
    public String getWECOZero() {
        return wECOZero;
    }

    @JsonProperty("WE_CO_zero")
    public void setWECOZero(String wECOZero) {
        this.wECOZero = wECOZero;
    }

    public Raw withWECOZero(String wECOZero) {
        this.wECOZero = wECOZero;
        return this;
    }

    @JsonProperty("WE_NO2")
    public String getWENO2() {
        return wENO2;
    }

    @JsonProperty("WE_NO2")
    public void setWENO2(String wENO2) {
        this.wENO2 = wENO2;
    }

    public Raw withWENO2(String wENO2) {
        this.wENO2 = wENO2;
        return this;
    }

    @JsonProperty("O3_num")
    public String getO3Num() {
        return o3Num;
    }

    @JsonProperty("O3_num")
    public void setO3Num(String o3Num) {
        this.o3Num = o3Num;
    }

    public Raw withO3Num(String o3Num) {
        this.o3Num = o3Num;
        return this;
    }

    @JsonProperty("WE_NO2_zero")
    public String getWENO2Zero() {
        return wENO2Zero;
    }

    @JsonProperty("WE_NO2_zero")
    public void setWENO2Zero(String wENO2Zero) {
        this.wENO2Zero = wENO2Zero;
    }

    public Raw withWENO2Zero(String wENO2Zero) {
        this.wENO2Zero = wENO2Zero;
        return this;
    }

    @JsonProperty("raw_ppm_CO")
    public String getRawPpmCO() {
        return rawPpmCO;
    }

    @JsonProperty("raw_ppm_CO")
    public void setRawPpmCO(String rawPpmCO) {
        this.rawPpmCO = rawPpmCO;
    }

    public Raw withRawPpmCO(String rawPpmCO) {
        this.rawPpmCO = rawPpmCO;
        return this;
    }

    @JsonProperty("AE_O3+NO2")
    public String getAEO3NO2() {
        return aEO3NO2;
    }

    @JsonProperty("AE_O3+NO2")
    public void setAEO3NO2(String aEO3NO2) {
        this.aEO3NO2 = aEO3NO2;
    }

    public Raw withAEO3NO2(String aEO3NO2) {
        this.aEO3NO2 = aEO3NO2;
        return this;
    }

    @JsonProperty("AFE")
    public String getAFE() {
        return aFE;
    }

    @JsonProperty("AFE")
    public void setAFE(String aFE) {
        this.aFE = aFE;
    }

    public Raw withAFE(String aFE) {
        this.aFE = aFE;
        return this;
    }

    @JsonProperty("temp_num")
    public String getTempNum() {
        return tempNum;
    }

    @JsonProperty("temp_num")
    public void setTempNum(String tempNum) {
        this.tempNum = tempNum;
    }

    public Raw withTempNum(String tempNum) {
        this.tempNum = tempNum;
        return this;
    }

    @JsonProperty("WE_O3+NO2")
    public String getWEO3NO2() {
        return wEO3NO2;
    }

    @JsonProperty("WE_O3+NO2")
    public void setWEO3NO2(String wEO3NO2) {
        this.wEO3NO2 = wEO3NO2;
    }

    public Raw withWEO3NO2(String wEO3NO2) {
        this.wEO3NO2 = wEO3NO2;
        return this;
    }

    @JsonProperty("AE_NO2_zero")
    public String getAENO2Zero() {
        return aENO2Zero;
    }

    @JsonProperty("AE_NO2_zero")
    public void setAENO2Zero(String aENO2Zero) {
        this.aENO2Zero = aENO2Zero;
    }

    public Raw withAENO2Zero(String aENO2Zero) {
        this.aENO2Zero = aENO2Zero;
        return this;
    }

    @JsonProperty("WE_O3+NO2_zero")
    public String getWEO3NO2Zero() {
        return wEO3NO2Zero;
    }

    @JsonProperty("WE_O3+NO2_zero")
    public void setWEO3NO2Zero(String wEO3NO2Zero) {
        this.wEO3NO2Zero = wEO3NO2Zero;
    }

    public Raw withWEO3NO2Zero(String wEO3NO2Zero) {
        this.wEO3NO2Zero = wEO3NO2Zero;
        return this;
    }

    @JsonProperty("AE_CO")
    public String getAECO() {
        return aECO;
    }

    @JsonProperty("AE_CO")
    public void setAECO(String aECO) {
        this.aECO = aECO;
    }

    public Raw withAECO(String aECO) {
        this.aECO = aECO;
        return this;
    }

    @JsonProperty("WE_CO")
    public String getWECO() {
        return wECO;
    }

    @JsonProperty("WE_CO")
    public void setWECO(String wECO) {
        this.wECO = wECO;
    }

    public Raw withWECO(String wECO) {
        this.wECO = wECO;
        return this;
    }

    @JsonProperty("AE_O3+NO2_zero")
    public String getAEO3NO2Zero() {
        return aEO3NO2Zero;
    }

    @JsonProperty("AE_O3+NO2_zero")
    public void setAEO3NO2Zero(String aEO3NO2Zero) {
        this.aEO3NO2Zero = aEO3NO2Zero;
    }

    public Raw withAEO3NO2Zero(String aEO3NO2Zero) {
        this.aEO3NO2Zero = aEO3NO2Zero;
        return this;
    }

    @JsonProperty("socket2AB")
    public String getSocket2AB() {
        return socket2AB;
    }

    @JsonProperty("socket2AB")
    public void setSocket2AB(String socket2AB) {
        this.socket2AB = socket2AB;
    }

    public Raw withSocket2AB(String socket2AB) {
        this.socket2AB = socket2AB;
        return this;
    }

    @JsonProperty("CO_num")
    public String getCONum() {
        return cONum;
    }

    @JsonProperty("CO_num")
    public void setCONum(String cONum) {
        this.cONum = cONum;
    }

    public Raw withCONum(String cONum) {
        this.cONum = cONum;
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

    public Raw withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("aECOZero", aECOZero).append("aENO2", aENO2).append("crc", crc).append("nO2Num", nO2Num).append("batteryLevel", batteryLevel).append("humNum", humNum).append("rawPpbO3NO2", rawPpbO3NO2).append("rawPpbNO2", rawPpbNO2).append("wECOZero", wECOZero).append("wENO2", wENO2).append("o3Num", o3Num).append("wENO2Zero", wENO2Zero).append("rawPpmCO", rawPpmCO).append("aEO3NO2", aEO3NO2).append("aFE", aFE).append("tempNum", tempNum).append("wEO3NO2", wEO3NO2).append("aENO2Zero", aENO2Zero).append("wEO3NO2Zero", wEO3NO2Zero).append("aECO", aECO).append("wECO", wECO).append("aEO3NO2Zero", aEO3NO2Zero).append("socket2AB", socket2AB).append("cONum", cONum).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(wENO2).append(wEO3NO2).append(o3Num).append(wECOZero).append(aFE).append(crc).append(tempNum).append(batteryLevel).append(aENO2Zero).append(aENO2).append(socket2AB).append(wECO).append(aEO3NO2Zero).append(aEO3NO2).append(rawPpmCO).append(rawPpbO3NO2).append(cONum).append(wEO3NO2Zero).append(additionalProperties).append(wENO2Zero).append(aECO).append(aECOZero).append(rawPpbNO2).append(humNum).append(nO2Num).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Raw) == false) {
            return false;
        }
        Raw rhs = ((Raw) other);
        return new EqualsBuilder().append(wENO2, rhs.wENO2).append(wEO3NO2, rhs.wEO3NO2).append(o3Num, rhs.o3Num).append(wECOZero, rhs.wECOZero).append(aFE, rhs.aFE).append(crc, rhs.crc).append(tempNum, rhs.tempNum).append(batteryLevel, rhs.batteryLevel).append(aENO2Zero, rhs.aENO2Zero).append(aENO2, rhs.aENO2).append(socket2AB, rhs.socket2AB).append(wECO, rhs.wECO).append(aEO3NO2Zero, rhs.aEO3NO2Zero).append(aEO3NO2, rhs.aEO3NO2).append(rawPpmCO, rhs.rawPpmCO).append(rawPpbO3NO2, rhs.rawPpbO3NO2).append(cONum, rhs.cONum).append(wEO3NO2Zero, rhs.wEO3NO2Zero).append(additionalProperties, rhs.additionalProperties).append(wENO2Zero, rhs.wENO2Zero).append(aECO, rhs.aECO).append(aECOZero, rhs.aECOZero).append(rawPpbNO2, rhs.rawPpbNO2).append(humNum, rhs.humNum).append(nO2Num, rhs.nO2Num).isEquals();
    }

}
