package com.qat.samples.sysmgmt.fiscal;

import java.util.List;

import com.qat.samples.sysmgmt.util.ModelCosmeDamiao;
import com.qat.samples.sysmgmt.util.Tarefa;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class Regime extends ModelCosmeDamiao
{
	/** The SendSolv id for the account. */
	private Integer id;

	/** The type of an account. */
	private String nome;

	/** The description. */
	private String descricao;

	private List<Tarefa> listTarefa;

	/**
	 * Default constructor.
	 */
	public Regime()
	{

	}

	public Regime(Integer id)
	{
		super();
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public List<Tarefa> getListTarefa()
	{
		return listTarefa;
	}

	public void setListTarefa(List<Tarefa> listTarefa)
	{
		this.listTarefa = listTarefa;
	}

	@Override
	public String toString()
	{
		return "Regime [getId()=" + getId() + ", getNome()=" + getNome() + ", getDescricao()=" + getDescricao()
				+ ", getListTarefa()=" + getListTarefa() + ", toString()=" + super.toString() + "]";
	}

}
