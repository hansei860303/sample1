package methodologic.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import methodologic.sample.model.Employees;

@Mapper
public interface EmployeesMapper {
	
	//　総件数
	Long count();
	
	//　一覧
	List<Employees> selectAll(RowBounds rowBounds);
	
	//一件
	Employees selectByPrimaryKey(Long id);
	
	// 新規
	int insert(Employees record);
	
	// 更新
	int updateByPrimaryKey(Employees record);
	
	// 削除
	int deleteByPrimaryKey(Long id);
	
}
