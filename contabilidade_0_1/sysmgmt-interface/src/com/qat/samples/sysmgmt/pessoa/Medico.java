package com.qat.samples.sysmgmt.pessoa;

import java.util.List;

import com.qat.samples.sysmgmt.clinica.Consulta;
import com.qat.samples.sysmgmt.clinica.EspecialidadePessoa;
import com.qat.samples.sysmgmt.dp.HorarioFunc;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class Medico extends Pessoa
{
	private List<EspecialidadePessoa> especialidadeList;
	private List<Consulta> consultaList;
	private List<HorarioFunc> horarioList;

	/**
	 * Default constructor.
	 */
	public Medico()
	{
		super();
	}

	public Medico(Integer id)
	{
		super();
		setId(id);
	}

	public List<EspecialidadePessoa> getEspecialidadeList()
	{
		return especialidadeList;
	}

	public void setEspecialidadeList(List<EspecialidadePessoa> especialidadeList)
	{
		this.especialidadeList = especialidadeList;
	}

	public List<Consulta> getConsultaList()
	{
		return consultaList;
	}

	public void setConsultaList(List<Consulta> consultaList)
	{
		this.consultaList = consultaList;
	}

	public List<HorarioFunc> getHorarioList()
	{
		return horarioList;
	}

	public void setHorarioList(List<HorarioFunc> horarioList)
	{
		this.horarioList = horarioList;
	}

	@Override
	public String toString()
	{
		return "Medico [getEspecialidadeList()=" + getEspecialidadeList() + ", getConsultaList()=" + getConsultaList()
				+ ", getHorarioList()=" + getHorarioList() + ", toString()=" + super.toString() + "]";
	}

}
