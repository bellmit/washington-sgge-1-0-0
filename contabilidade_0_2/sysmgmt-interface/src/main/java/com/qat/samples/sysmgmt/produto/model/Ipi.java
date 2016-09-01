package com.qat.samples.sysmgmt.produto.model;

import com.qat.samples.sysmgmt.fiscal.model.Classificacao;
import com.qat.samples.sysmgmt.util.model.ModelCosmeDamiao;

/**
 * This class is a representation of an Account (i.e Checking, Savings, etc.). This represents an account for a transfer
 * setting.
 */
@SuppressWarnings("serial")
public class ipi extends ModelCosmeDamiao
{
	/** The SendSolv id for the account. */
private Integer id;

private Integer prodId;

private DoisValores sitTributaria;

private String classeCigarrosBebidas;

private String cNPJProdutor;

private String codControleIPI;

private String qtdSeloIPI;

private DoisValores codEnquadramento;

private DoisValores tipoCalculo;

private Double aliquotaIPI;


	/**
	 * Default constructor.
	 */
	public ipi()
	{
		super();
	}

	public ipi(Integer id)
	{
		super();
		this.id = id;
	}

	public ipi(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId()
	{
		return id;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo()
	{
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	/**
	 * @return the cdBarras
	 */
	public String getCdBarras()
	{
		return cdBarras;
	}

	/**
	 * @param cdBarras the cdBarras to set
	 */
	public void setCdBarras(String cdBarras)
	{
		this.cdBarras = cdBarras;
	}

	/**
	 * @return the classificacao
	 */
	public Classificacao getClassificacao()
	{
		return classificacao;
	}

	/**
	 * @param classificacao the classificacao to set
	 */
	public void setClassificacao(Classificacao classificacao)
	{
		this.classificacao = classificacao;
	}

	/**
	 * @return the dataCreate
	 */
	public Long getDataCreate()
	{
		return dataCreate;
	}

	/**
	 * @param dataCreate the dataCreate to set
	 */
	public void setDataCreate(Long dataCreate)
	{
		this.dataCreate = dataCreate;
	}

	/**
	 * @return the produto
	 */
	public String getProduto()
	{
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(String produto)
	{
		this.produto = produto;
	}

	/**
	 * @return the aplicacao
	 */
	public String getAplicacao()
	{
		return aplicacao;
	}

	/**
	 * @param aplicacao the aplicacao to set
	 */
	public void setAplicacao(String aplicacao)
	{
		this.aplicacao = aplicacao;
	}

	public String getFracao() {
		return fracao;
	}

	public void setFracao(String fracao) {
		this.fracao = fracao;
	}



	public UniMed getUniMed() {
		return uniMed;
	}

	public void setUniMed(UniMed uniMed) {
		this.uniMed = uniMed;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public Double getPorcao() {
		return porcao;
	}

	public void setPorcao(Double porcao) {
		this.porcao = porcao;
	}

	public Double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public String getModoUso() {
		return modoUso;
	}

	public void setModoUso(String modoUso) {
		this.modoUso = modoUso;
	}

	@Override
	public String toString() {
		return "Produto [getId()=" + getId() + ", getNcm()=" + getNcm() + ", getMarca()=" + getMarca()
				+ ", getCodigo()=" + getCodigo() + ", getCdBarras()=" + getCdBarras() + ", getClassificacao()="
				+ getClassificacao() + ", getDataCreate()=" + getDataCreate() + ", getProduto()=" + getProduto()
				+ ", getAplicacao()=" + getAplicacao() + ", getFracao()=" + getFracao() + ", getUniMed()=" + getUniMed()
				+ ", getGrupo()=" + getGrupo() + ", getSubGrupo()=" + getSubGrupo() + ", getPorcao()=" + getPorcao()
				+ ", getPesoBruto()=" + getPesoBruto() + ", getPesoLiquido()=" + getPesoLiquido() + ", getModoUso()="
				+ getModoUso() + ", toString()=" + super.toString() + "]";
	}




}
