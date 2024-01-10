package com.newspage.iexcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newspage.beans.Sinhvien;
import com.newspage.beans.User;

public class FileUploadDao extends BaseDAO{
	
	public boolean saveFileDataInDB(List<Sinhvien> sinhvienList){
		String sql = "insert into users (MAX, PASSWORD) values(:msv, :ngaysinh)";
		String sqll = "insert into sinhvien (MSV, HOTEN, NGAYSINH, LOP, CHUCVU) VALUES (:msv, CONCAT(:hoten,' ',:dem), :ngaysinh, :lop, :chucvu)"; 
		String sqlll = "insert into drl (msv, tthai) values(:msv, 'Chưa đánh giá')";

		try {
			List<Map<String, String>> batchUpdateParams = new ArrayList<>();

			for(Sinhvien vo : sinhvienList){
				Map<String, String> paramMap = new HashMap<>();
				paramMap.put("msv", vo.getMsv());
				paramMap.put("hoten", vo.getHoten());
				paramMap.put("ngaysinh", vo.getNgaysinh());
				paramMap.put("lop", vo.getLop());
				//paramMap.put("chucvu", vo.getChucvu());
				if ( vo.getChucvu() == null) {
					paramMap.put("chucvu", "sv");
				} else {
					paramMap.put("chucvu", "loptruong");	
				}
				paramMap.put("dem", vo.getDem());
				
				batchUpdateParams.add(paramMap);
			}
			getNamedParamJdbcTemplate().batchUpdate(sql, batchUpdateParams.toArray(new Map[batchUpdateParams.size()] ));
			getNamedParamJdbcTemplate().batchUpdate(sqll, batchUpdateParams.toArray(new Map[batchUpdateParams.size()] ));
			getNamedParamJdbcTemplate().batchUpdate(sqlll, batchUpdateParams.toArray(new Map[batchUpdateParams.size()] ));

			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	

}