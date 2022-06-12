package methodologic.sample.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import methodologic.sample.mapper.EmployeesMapper;
import methodologic.sample.model.Employees;

@RequiredArgsConstructor
@Service
public class EmployeesService {

	private final EmployeesMapper mapper;
	
	private int offset;
	private final int limit = 20;
	
	public List<Employees> selectRecord(int pageNo) {
		
		RowBounds rowBounds = new RowBounds();
		if(pageNo != -1 && pageNo > 0 ) {
			offset = (pageNo -1) * limit;
			rowBounds = new RowBounds(offset,limit);
		}
		List<Employees> Employees = mapper.selectAll(rowBounds);
		
		return Employees;
	}
}
