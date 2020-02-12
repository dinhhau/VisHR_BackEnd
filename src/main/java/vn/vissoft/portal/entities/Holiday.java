package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HOLIDAY", uniqueConstraints = { @UniqueConstraint(columnNames = { "HCODE" })})
public class Holiday implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HID")
    private int hID;

    @Column(name = "HNAME")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩ" +
                        "ũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎ" +
                          "ỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")
    private String hName;

    @Column(name = "HCODE")
    @NotBlank(message = "hCode can't not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(max = 20, message = "Length hCode max 20 character")
    private String hCode;

    @Column(name = "H_TIME_BEGIN")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date hTimeBegin;

    @Column(name = "H_TIME_END")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date hTimeEnd;

    @Column(name = "STATUS")
    @NotNull
    private int status;

    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Date gethTimeBegin() {
        return hTimeBegin;
    }

    public void sethTimeBegin(Date hTimeBegin) {
        this.hTimeBegin = hTimeBegin;
    }

    public Date gethTimeEnd() {
        return hTimeEnd;
    }

    public void sethTimeEnd(Date hTimeEnd) {
        this.hTimeEnd = hTimeEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String gethCode() {
        return hCode;
    }

    public void sethCode(String hCode) {
        this.hCode = hCode;
    }

}
