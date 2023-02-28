package br.com.unifip.projetoApi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import br.com.unifip.projetoApi.entidades.Musica;
import br.com.unifip.projetoApi.servicos.ServicoMusica;

@RestController
@RequestMapping("/v1/musica")
public class MusicaControler {
	
	@Autowired
	private ServicoMusica servicoMusica;
	
	
	@GetMapping(value = "/listaDeMusicas")
	public ResponseEntity<List<Musica>> getListaDeMusicas(){
		return new ResponseEntity<List<Musica>>(servicoMusica.recuperaListaDeMusica(), HttpStatus.OK);
	}
	
	@PostMapping("/cadastroMusica")
	public ResponseEntity<Musica> cadastraMusica(@RequestBody Musica musica){
		return new ResponseEntity<Musica>(servicoMusica.cadastraMusica(musica), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeMusica/{nome}")
	@ResponseBody 
	public ResponseEntity<Musica> removeMusica(@PathVariable String nome){
		Musica musicaEncontrada = servicoMusica.encontraMusica(nome);
		if (musicaEncontrada != null) {
			servicoMusica.removeMusica(musicaEncontrada);
			return ResponseEntity.ok(musicaEncontrada);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	
	}

}
