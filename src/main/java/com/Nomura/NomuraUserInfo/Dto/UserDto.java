package com.Nomura.NomuraUserInfo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int userId;
	private String userName;
	private String address;
	private String city;

}
