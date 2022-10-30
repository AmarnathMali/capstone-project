package com.ers.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {

private int reimbursementId;
private int userId;
private String reason;
private int amount;
private String status;
private Date raisedOn;
private String userName;
}
