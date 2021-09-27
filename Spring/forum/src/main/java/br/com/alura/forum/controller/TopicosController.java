package br.com.alura.forum.controller;


import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController()
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepositoy;
	
	
	@GetMapping
	@Cacheable(value = "listaDeTopicos")
	public Page<TopicoDTO> lista(
			@RequestParam(required = false) String nomeCurso, 
			@PageableDefault(
					sort = "id", direction = Direction.DESC ,
					page = 0, size = 3
					) Pageable paginacao ) {
		
		
		Page<Topico>  pageTopicos;
		if(nomeCurso == null) {		
			pageTopicos = this.topicoRepository.findAll(paginacao);
		}else {
			 pageTopicos = this.topicoRepository.findByCurso_Nome(nomeCurso,paginacao); 
		}
		return TopicoDTO.converterTopicos(pageTopicos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
		
		Optional<Topico> topico = this.topicoRepository.findById(id);
		
		if(topico.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
	}
	
	
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		
		Topico topico = topicoForm.converter(cursoRepositoy);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder
				.path("/topicos/{id}")
				.buildAndExpand(topico.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
		
	}
	
	
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> atualizar(
			@PathVariable Long id, 
			@RequestBody @Valid AtualizacaoTopicoForm topicoForm ){
		
		Optional<Topico> optionalTopico = this.topicoRepository.findById(id);
		
		if(optionalTopico.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Topico topico = topicoForm.atualizar(id, optionalTopico.get());
		
		return ResponseEntity.ok(new TopicoDTO(topico));
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		

		Optional<Topico> optionalTopico = this.topicoRepository.findById(id);
		
		if(optionalTopico.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		
		this.topicoRepository.deleteById(id);

		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
