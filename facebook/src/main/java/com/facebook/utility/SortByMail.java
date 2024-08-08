package com.facebook.utility;

import java.util.Comparator;

import com.facebook.entity.FacebookUser;

public class SortByMail implements Comparator<FacebookUser>{

		public int compare(FacebookUser o1, FacebookUser o2) {
			// TODO Auto-generated method stub
			return o1.getEmail().compareTo(o2.getName());

	}

}
