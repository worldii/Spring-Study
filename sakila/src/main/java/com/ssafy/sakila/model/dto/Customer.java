package com.ssafy.sakila.model.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
customer_id    smallint unsigned
store_id    tinyint unsigned
first_name    varchar(45)
last_name    varchar(45)
email    varchar(50)
address_id    smallint unsigned
active    tinyint(1)
create_date    datetime
last_update    timestamp
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
	private int customerId;
	private int storeId;
	private String firstName;
	private String lastName;
	private String email;
	private int addressId;
	private boolean active;
	private Timestamp createDate;
	private Timestamp lastUpdate;
}