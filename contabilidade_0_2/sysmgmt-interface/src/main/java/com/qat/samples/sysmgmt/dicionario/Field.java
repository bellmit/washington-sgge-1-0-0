package com.qat.samples.sysmgmt.advocacia;

import com.qat.samples.sysmgmt.pessoa.model.Pessoa;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class Field extends ModelCosmeDamiao
{

	private String tipo;
	private Integer tamanho;
	private Boolean requerid;
	private Boolean primaryKey;
	private Boolean forenkey;
	private Boolean model;
	private Boolean xml;
	
	public Field()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Advogado(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public Advogado(String string, String string2, Object object) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "Advogado [toString()=" + super.toString() + "]";
	}

}
