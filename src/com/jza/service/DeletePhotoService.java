package com.jza.service;

import com.jza.util.DbUtil;

public class DeletePhotoService {
	public void deletePhotoByPhoto_Id(int photo_id) {
		String sql = "delete from photo where photo_id=?";
		String[] params={String.valueOf(photo_id)};
		DbUtil.executeUpdate(sql, params);
	}
}
