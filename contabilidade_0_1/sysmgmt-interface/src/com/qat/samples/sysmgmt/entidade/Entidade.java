package com.qat.samples.sysmgmt.entidade;

import java.util.List;

import com.qat.samples.sysmgmt.banco.BancoPessoa;
import com.qat.samples.sysmgmt.cnae.CnaeEmpresa;
import com.qat.samples.sysmgmt.fiscal.Regime;
import com.qat.samples.sysmgmt.util.Configuracao;
import com.qat.samples.sysmgmt.util.Documento;
import com.qat.samples.sysmgmt.util.Email;
import com.qat.samples.sysmgmt.util.Endereco;
import com.qat.samples.sysmgmt.util.ModelCosmeDamiao;
import com.qat.samples.sysmgmt.util.Telefone;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class Entidade extends ModelCosmeDamiao
{
	/** The SendSolv id for the account. */
	private Integer id;

	/** The type of an account. */
	private String nome;

	private Regime regime;

	private Integer entidadeId;

	private EntidadeTypeEnum entidadeEnum;

	private Configuracao configuracao;

	private List<Endereco> enderecos;

	private List<Documento> documentos;

	private List<Email> emails;

	private List<Telefone> telefones;

	private List<CnaeEmpresa> cnaes;

	private List<Usuario> usuarios;

	private List<BancoPessoa> bancos;

	private List<NotificationPreferences> notificacoes;

	public List<Usuario> getUsuarios()
	{
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}

	public List<BancoPessoa> getBancos()
	{
		return bancos;
	}

	public void setBancos(List<BancoPessoa> bancos)
	{
		this.bancos = bancos;
	}

	/**
	 * Default constructor.
	 */
	public Entidade()
	{
		super();
	}

	public Integer getEntidadeEnumValue()
	{
		if (entidadeEnum != null)
		{
			return entidadeEnum.getValue();
		}
		return null;
	}

	public void setEntidadeEnumValue(Integer acaoTypeValue)
	{
		entidadeEnum = EntidadeTypeEnum.enumForValue(acaoTypeValue);
	}

	/**
	 * @return the id
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos()
	{
		return enderecos;
	}

	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos)
	{
		this.enderecos = enderecos;
	}

	/**
	 * @return the documentos
	 */
	public List<Documento> getDocumentos()
	{
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<Documento> documentos)
	{
		this.documentos = documentos;
	}

	/**
	 * @return the emails
	 */
	public List<Email> getEmails()
	{
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<Email> emails)
	{
		this.emails = emails;
	}

	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones()
	{
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(List<Telefone> telefones)
	{
		this.telefones = telefones;
	}

	/**
	 * @return the cnaes
	 */
	public List<CnaeEmpresa> getCnaes()
	{
		return cnaes;
	}

	/**
	 * @param cnaes the cnaes to set
	 */
	public void setCnaes(List<CnaeEmpresa> cnaes)
	{
		this.cnaes = cnaes;
	}

	/**
	 * @return the regime
	 */
	public Regime getRegime()
	{
		return regime;
	}

	/**
	 * @param regime the regime to set
	 */
	public void setRegime(Regime regime)
	{
		this.regime = regime;
	}

	/**
	 * @return the entidadeEnum
	 */
	public EntidadeTypeEnum getEntidadeEnum()
	{
		return entidadeEnum;
	}

	/**
	 * @param entidadeEnum the entidadeEnum to set
	 */
	public void setEntidadeEnum(EntidadeTypeEnum entidadeEnum)
	{
		this.entidadeEnum = entidadeEnum;
	}

	/**
	 * @return the configuracao
	 */
	public Configuracao getConfiguracao()
	{
		return configuracao;
	}

	/**
	 * @param configuracao the configuracao to set
	 */
	public void setConfiguracao(Configuracao configuracao)
	{
		this.configuracao = configuracao;
	}

	/**
	 * @return the entidadeId
	 */
	public Integer getEntidadeId()
	{
		return entidadeId;
	}

	/**
	 * @param entidadeId the entidadeId to set
	 */
	public void setEntidadeId(Integer entidadeId)
	{
		this.entidadeId = entidadeId;
	}

	public List<NotificationPreferences> getNotificacoes()
	{
		return notificacoes;
	}

	public void setNotificacoes(List<NotificationPreferences> notificacoes)
	{
		this.notificacoes = notificacoes;
	}

	@Override
	public String toString()
	{
		return "Entidade [getUsuarios()=" + getUsuarios() + ", getBancos()=" + getBancos()
				+ ", getEntidadeEnumValue()=" + getEntidadeEnumValue() + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getEnderecos()=" + getEnderecos() + ", getDocumentos()=" + getDocumentos()
				+ ", getEmails()=" + getEmails() + ", getTelefones()=" + getTelefones() + ", getCnaes()=" + getCnaes()
				+ ", getRegime()=" + getRegime() + ", getEntidadeEnum()=" + getEntidadeEnum() + ", getConfiguracao()="
				+ getConfiguracao() + ", getEntidadeId()=" + getEntidadeId() + ", getNotificacoes()="
				+ getNotificacoes() + ", toString()=" + super.toString() + "]";
	}

}
