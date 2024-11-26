/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Modelos.Pregunta;
import Modelos.Sesion;
import Modelos.Tema;
import Repositorios.CursoProgressManager;
import Repositorios.PreguntaRepository;
import Repositorios.SesionRepository;
import Repositorios.TemaRepository;
import java.util.List;

/**
 *
 * @author user
 */
public class CursoServicio {
    private TemaRepository temaRepository;
    private PreguntaRepository preguntaRepository;
    private SesionRepository sesionRepository;
    private CursoProgressManager cursoProgressManager;

    public CursoServicio() {
        this.temaRepository=new TemaRepository();
        this.preguntaRepository=new PreguntaRepository();
        this.sesionRepository=new SesionRepository();
        this.cursoProgressManager=new CursoProgressManager();
    }
    
    public List<Tema> buscarTemaPorIdCurso(String cursoId) {
        return temaRepository.findByCursoId(cursoId);
    }
    
    public List<Pregunta> buscarPreguntaPorIdTema(String temaId) {
        return preguntaRepository.findByTemaId(temaId);
    }

    public List<Sesion> buscarSesionPorIdCurso(String cursoId) {
        return sesionRepository.findByCursoId(cursoId);
    }
    
    public boolean marcarPreguntaCompletada(String preguntaId) {
        return cursoProgressManager.marcarPreguntaCompletada(preguntaId);
    }

}
