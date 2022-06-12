package methodologic.sample.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import methodologic.sample.mapper.CustomersMapper;
import methodologic.sample.model.Customers;

@RequiredArgsConstructor
@Service
public class CustomersService {
	
	private final CustomersMapper mapper;
	
	private int offset;
	private final int limit = 20;
	
	public List<Customers> selectRecord(int pageNo) {
		
		RowBounds rowBounds = new RowBounds();
		if(pageNo != -1 && pageNo > 0 ) {
			offset = (pageNo -1) * limit;
			rowBounds = new RowBounds(offset,limit);
		}
		List<Customers> users = mapper.selectAll(rowBounds);
		
		return users;
	}
}
