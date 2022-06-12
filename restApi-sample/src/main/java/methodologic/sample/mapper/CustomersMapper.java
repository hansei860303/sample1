package methodologic.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import methodologic.sample.model.Customers;

@Mapper
public interface CustomersMapper {
	
	//　総件数
	Long count();
	
	//　一覧
	List<Customers> selectAll(RowBounds rowBounds);
	
	// 一件
	Customers selectByPrimaryKey(Long id);
	
	// 新規
	int insert(Customers record);
	
	// 更新
	int updateByPrimaryKey(Customers record);
	
	// 削除
	int deleteByPrimaryKey(Long id);
	
	
}
