package sample.controller;

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
import sample.mapper.PhasesMapper;
import sample.model.Phases;

@CrossOrigin
@RequestMapping("/api/phases")
@RequiredArgsConstructor
@RestController
public class PhasesController {
	
	private final PhasesMapper mapper;
	
	@Operation(summary = "全件数取得します")
	@GetMapping("/count")
	Long countAll() {
		return mapper.count();
	}
	
	@Operation(summary = "一件を取得")
	@GetMapping("/findById/{id}")
	Phases findById(@PathVariable Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Operation(summary = "全件取得")
	@GetMapping("/findAll")
	List<Phases> findAll() {
		return mapper.selectAll();
	}
	
	@Operation(summary = "データを新規・更新します")
	@PutMapping("/save")
	int save(@RequestBody Phases newPhase) {
		if (newPhase.getId() == null) {
			return mapper.insert(newPhase);
		} else {
			return mapper.updateByPrimaryKey(newPhase);
		}

	}
	
	@Operation(summary = "データを削除します")
	@DeleteMapping("/delete/{id}")
	int deleteById(@PathVariable Long id) {
		return mapper.deleteByPrimaryKey(id);
	}	
}
