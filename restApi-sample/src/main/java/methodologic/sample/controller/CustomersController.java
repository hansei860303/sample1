package methodologic.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import methodologic.sample.mapper.CustomersMapper;
import methodologic.sample.model.Customers;
import methodologic.sample.service.CustomersService;

@CrossOrigin
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@RestController
public class CustomersController {
	
	private final CustomersMapper mapper;
	private final CustomersService service;
	
	@Operation(summary = "全件数取得します")
	@GetMapping("/count")
	Long countAll() {
		return mapper.count();
	}
	
	@Operation(summary = "一件を取得")
	@GetMapping("/findById/{id}")
	Customers findById(@PathVariable Long id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	@Operation(summary = "指定ページから件数取得、-1の場合、全件取得")
	@GetMapping("/findAll/{pageNo}")
	List<Customers> findAll(@PathVariable int pageNo) {
		return service.selectRecord(pageNo);
	}
	
	@Operation(summary = "データを新規・更新します")
	@PutMapping("/save")
	int save(@RequestBody Customers newCustomers) {
		if (newCustomers.getId() == null) {
			return mapper.insert(newCustomers);
		} else {
			return mapper.updateByPrimaryKey(newCustomers);
		}

	}
	
	@Operation(summary = "データを削除します")
	@DeleteMapping("/delete/{id}")
	int deleteById(@PathVariable Long id) {
		return mapper.deleteByPrimaryKey(id);
	}	

}
