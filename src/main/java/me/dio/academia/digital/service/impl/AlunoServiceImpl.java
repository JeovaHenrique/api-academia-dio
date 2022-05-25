package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository Repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return Repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        Aluno aluno = Repository.findById(id).get();
        return aluno;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento == null) {
            return Repository.findAll();
        }else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return Repository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        AlunoUpdateForm alunoForm = new AlunoUpdateForm();

        alunoForm.setNome(formUpdate.getNome());
        alunoForm.setBairro(formUpdate.getBairro());
        alunoForm.setDataDeNascimento(formUpdate.getDataDeNascimento());

        Aluno aluno =  Repository.findById(id).get();

        if ((aluno.getNome() != alunoForm.getNome()) && alunoForm.getNome() != null) {
            aluno.setNome(alunoForm.getNome());
        }

        if ((aluno.getBairro() != alunoForm.getBairro())
                && alunoForm.getBairro() != null) {

            aluno.setBairro(alunoForm.getBairro());
        }

        if ((aluno.getDataDeNascimento() != alunoForm.getDataDeNascimento())
                && alunoForm.getDataDeNascimento() != null) {

            aluno.setDataDeNascimento(alunoForm.getDataDeNascimento());
        }

        return Repository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        Repository.deleteById(id);

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = Repository.findById(id).get();
        return aluno.getAvaliacoes();
    }
}
