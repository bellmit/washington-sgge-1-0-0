package com.qat.samples.sysmgmt.util.model;

import com.qat.framework.model.II18nEnum;
import com.qat.framework.model.IIntegerEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum RiskLevelEnum.
 *
 * @author abarros
 * @version 1.0
 * @created 21-Jul-2014 10:00:07 AM
 */
public enum TabelaEnum implements IIntegerEnum, II18nEnum
{

	/**
	 * The high.
	 *
	 * REGIME
	 * EMPRESA
	 * DOCUMENTO
	 * EMAIL
	 * ENDERECO
	 * TELEFONE
	 * SOCIO
	 * HISTORICO
	 * CNAE
	 * CSOSN
	 * NCM
	 * CIDADE
	 * CNAEPORRELACIONAMENTO
	 * ESTADO
	 * UNIMED
	 * CFOP
	 * FUNCIONARIO
	 * SALARIO
	 */

	REGIME(0, "sendsolv.base.model.risklevelenum.high"),

	/** The low. */
	EMPRESA(1, "sendsolv.base.model.risklevelenum.low"),

	/** The medium. */
	DOCUMENTO(2, "sendsolv.base.model.risklevelenum.medium"),

	/** The unknown. */
	EMAIL(3, "sendsolv.base.model.risklevelenum.unknown"),

	/** The endereco. */
	ENDERECO(4, "sendsolv.base.model.risklevelenum.high"),

	/** The low. */
	TELEFONE(5, "sendsolv.base.model.risklevelenum.low"),

	/** The medium. */
	SOCIO(6, "sendsolv.base.model.risklevelenum.medium"),

	/** The unknown. */
	HISTORICO(7, "sendsolv.base.model.risklevelenum.unknown"),

	/** The cnae. */
	CNAE(8, "sendsolv.base.model.risklevelenum.high"),

	/** The low. */
	CSOSN(9, "sendsolv.base.model.risklevelenum.low"),

	/** The medium. */
	NCM(10, "sendsolv.base.model.risklevelenum.medium"),

	/** The unknown. */
	CIDADE(11, "sendsolv.base.model.risklevelenum.unknown"),

	/** The cnaeporrelacionamento. */
	CNAEPORRELACIONAMENTO(12, "sendsolv.base.model.risklevelenum.high"),

	/** The estado. */
	ESTADO(13, "sendsolv.base.model.risklevelenum.unknown"),

	/** The unimed. */
	UNIMED(14, "sendsolv.base.model.risklevelenum.high"),

	/** The low. */
	CFOP(15, "sendsolv.base.model.risklevelenum.low"),

	/** The medium. */
	FUNCIONARIO(16, "sendsolv.base.model.risklevelenum.medium"),

	CLIENTE(17, "sendsolv.base.model.risklevelenum.high"),

	/** The low. */
	FORNECEDOR(18, "sendsolv.base.model.risklevelenum.low"),

	/** The medium. */
	TRANSPORTADOR(19, "sendsolv.base.model.risklevelenum.medium"),

	CONDPAG(20, "sendsolv.base.model.risklevelenum.medium"),

	CONVENIO(21, "sendsolv.base.model.risklevelenum.medium"),

	/** The unknown. */
	SALARIO(22, "sendsolv.base.model.risklevelenum.unknown"),

	PESSOA(23, "sendsolv.base.model.risklevelenum.medium"),

	PROFISSAO(24, "sendsolv.base.model.risklevelenum.medium"),

	CONVENIOPESSOA(25, "sendsolv.base.model.risklevelenum.medium"),

	CONDPAGPESSOA(26, "sendsolv.base.model.risklevelenum.medium"),

	TIPOPAG(27, "sendsolv.base.model.risklevelenum.medium"),

	TIPOPAGREG(28, "sendsolv.base.model.risklevelenum.medium"),

	BANCO(29, "sendsolv.base.model.risklevelenum.medium"),

	AGENCIA(30, "sendsolv.base.model.risklevelenum.medium"),

	BANCOPESOA(31, "sendsolv.base.model.risklevelenum.medium"),

	CONTATO(32, "sendsolv.base.model.risklevelenum.medium"),

	CONTATOITENS(33, "sendsolv.base.model.risklevelenum.medium"),

	ORDEMSERVICO(34, "sendsolv.base.model.risklevelenum.medium"),

	ORDEMSERVICOITENS(35, "sendsolv.base.model.risklevelenum.medium"),

	ORDEMSERVICOTYPES(36, "sendsolv.base.model.risklevelenum.medium"),

	ORDEMSERVICOSTATUS(37, "sendsolv.base.model.risklevelenum.medium"),

	TABELA(38, "sendsolv.base.model.risklevelenum.medium"),

	ATRIBUTOS(39, "sendsolv.base.model.risklevelenum.medium"),

	EVENTOS(40, "sendsolv.base.model.risklevelenum.medium"),

	BENEFICIOS(41, "sendsolv.base.model.risklevelenum.medium"),

	CUSTO(42, "sendsolv.base.model.risklevelenum.medium"),

	NOTE(43, "sendsolv.base.model.risklevelenum.medium"),

	HORAFUNC(44, "sendsolv.base.model.risklevelenum.medium"),

	PRODUTO(45, "sendsolv.base.model.risklevelenum.medium"),

	NOTAFISCAL(46, "sendsolv.base.model.risklevelenum.medium"),

	ORCAMENTO(47, "sendsolv.base.model.risklevelenum.medium"),

	PEDIDOCOMPRAS(48, "sendsolv.base.model.risklevelenum.medium"),

	CONTAS(49, "sendsolv.base.model.risklevelenum.medium"),

	MARCA(50, "sendsolv.base.model.risklevelenum.medium"),

	DEPOSITO(51, "sendsolv.base.model.risklevelenum.medium"),

	FILIAL(52, "sendsolv.base.model.risklevelenum.medium"),

	SERVICO(53, "sendsolv.base.model.risklevelenum.medium"),

	PLANO(54, "sendsolv.base.model.risklevelenum.medium"),
	MEDICO(55, "sendsolv.base.model.risklevelenum.medium"),
	PACIENTE(56, "sendsolv.base.model.risklevelenum.medium"),
	EXAME(57, "sendsolv.base.model.risklevelenum.medium"),
	PLANOSAUDE(58, "sendsolv.base.model.risklevelenum.medium"),
	CONSULTA(59, "sendsolv.base.model.risklevelenum.medium"),

	USUARIO(60, "sendsolv.base.model.risklevelenum.medium"),

	CONDOMINIO(61, "sendsolv.base.model.risklevelenum.medium"),

	ADVOCACIA(62, "sendsolv.base.model.risklevelenum.medium"),

	CLINICA(63, "sendsolv.base.model.risklevelenum.medium"),

	SITE(64, "sendsolv.base.model.risklevelenum.medium"),

	CONTASPAGAR(65, "sendsolv.base.model.risklevelenum.medium"),

	CONTASRECEBER(66, "sendsolv.base.model.risklevelenum.medium"),

	BAIXARTITULO(67, "sendsolv.base.model.risklevelenum.medium"),

	TIPOBAIXA(68, "sendsolv.base.model.risklevelenum.medium"),

	TITULO(69, "sendsolv.base.model.risklevelenum.medium"),

	FORMAPG(70, "sendsolv.base.model.risklevelenum.medium"),

	CONTACORRENTE(71, "sendsolv.base.model.risklevelenum.medium"),

	CAIXA(72, "sendsolv.base.model.risklevelenum.medium"),
	PRODUTOPARENT(72, "sendsolv.base.model.risklevelenum.medium"),

	MARCAPRODUTO(73, "sendsolv.base.model.risklevelenum.medium"),

	GRUPO(74, "sendsolv.base.model.risklevelenum.medium"),

	SUBGRUPO(75, "sendsolv.base.model.risklevelenum.medium"),

	CUSTOITENS(76, "sendsolv.base.model.risklevelenum.medium"),

	ESTOQUE(77, "sendsolv.base.model.risklevelenum.medium"),

	PORCAO(78, "sendsolv.base.model.risklevelenum.medium"),

	PORCAOITENS(79, "sendsolv.base.model.risklevelenum.medium"),

	RENTABILIDADE(80, "sendsolv.base.model.risklevelenum.medium"),

	RENTABILIDADEITENS(73, "sendsolv.base.model.risklevelenum.medium"),

	TRIBUTACAO(73, "sendsolv.base.model.risklevelenum.medium"),


	BOLETO(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGALERTAS(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGCARNE(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGENTRADA(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGFISCAL(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGGERAL(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGPRODUTO(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGSMTP(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGURACAO(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGURACAONFE(73, "sendsolv.base.model.risklevelenum.medium"),

	DOISVALOR(73, "sendsolv.base.model.risklevelenum.medium"),

	SINDICO(73, "sendsolv.base.model.risklevelenum.medium"),

	INQUILINO(73, "sendsolv.base.model.risklevelenum.medium"),

	CONFIGVENDAS(73, "sendsolv.base.model.risklevelenum.medium");



	/** The code. */
	private Integer code;

	/** The label key. */
	private String labelKey;

	/**
	 * The Constructor.
	 *
	 * @param value the value
	 * @param labelKeyParam the label key param
	 */
	private TabelaEnum(Integer value, String labelKeyParam)
	{
		code = value;
		labelKey = labelKeyParam;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public Integer getValue()
	{
		return code;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the process status enum
	 */
	public static TabelaEnum enumForValue(Integer value)
	{
		for (TabelaEnum e : values())
		{
			if (e.getValue().equals(value))
			{
				return e;
			}
		}

		return null;
	}

	/**
	 * Gets the valid values.
	 *
	 * @return the valid values
	 */
	public static String getValidValues()
	{
		String comma = "";
		StringBuilder enumValue = new StringBuilder();

		for (TabelaEnum i : TabelaEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.model.II18nEnum#getLabelKey()
	 */
	/**
	 * Gets the label key.
	 *
	 * @return the label key
	 */
	@Override
	public String getLabelKey()
	{
		return labelKey;
	}
}