package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the ORCCAB database table.
 * 
 */
@Entity
@Table(name="ORCCAB")
public class Orccab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String numeroOrcamento;

	/*@Column(name="BANDEIRA")
	private String bandeira;

	@Column(name="COMISSAO_FATOR")
	private BigDecimal comissaoFator;

	private String concorrentes;

	private String condicaoPagamento;

	private String condicaoPagamentoDescricao;

	private Double condicaoPagamentoFator;

	@Column(name="GrupoImpostos")
	private String grupoImpostos;

	@Column(name="ObservacoesEntrega")
	private String observacoesEntrega;

	@Column(name="ORCCAB_AGENTE")
	private String orccabAgente;

	private BigDecimal orccab_Area;

	@Column(name="orccab_bloqueado")
	private boolean orccabBloqueado;

	@Column(name="orccab_bloquear_icad")
	private boolean orccabBloquearIcad;*/

	private Timestamp orccab_Cadastro;

	/*@Column(name="orccab_caminho_dwg")
	private String orccabCaminhoDwg;

	@Column(name="orccab_chave")
	private String orccabChave;

	@Column(name="orccab_cliente_bmp")
	private String orccabClienteBmp;

	@Column(name="orccab_cliente_cb_bairro")
	private String orccabClienteCbBairro;

	@Column(name="orccab_cliente_cb_cep")
	private String orccabClienteCbCep;

	@Column(name="orccab_cliente_cb_complemento")
	private String orccabClienteCbComplemento;

	@Column(name="orccab_cliente_cb_endereco")
	private String orccabClienteCbEndereco;

	@Column(name="orccab_cliente_cb_especie")
	private String orccabClienteCbEspecie;

	@Column(name="orccab_cliente_cb_municipio")
	private String orccabClienteCbMunicipio;

	@Column(name="orccab_cliente_cb_numero")
	private String orccabClienteCbNumero;

	@Column(name="orccab_cliente_cb_pais")
	private String orccabClienteCbPais;

	@Column(name="orccab_cliente_cb_uf")
	private String orccabClienteCbUf;

	@Column(name="orccab_cliente_cb_utilizar")
	private boolean orccabClienteCbUtilizar;

	private String orccab_cliente_CGC_cpf;*/

	private Integer orccab_cliente_Codigo;

	@Column(name="orccab_cliente_codinome")
	private String orccabClienteCodinome;

	/*@Column(name="orccab_cliente_end_bairro")
	private String orccabClienteEndBairro;

	@Column(name="orccab_cliente_end_cep")
	private String orccabClienteEndCep;

	@Column(name="orccab_cliente_end_complemento")
	private String orccabClienteEndComplemento;

	@Column(name="orccab_cliente_end_endereco")
	private String orccabClienteEndEndereco;

	@Column(name="orccab_cliente_end_especie")
	private String orccabClienteEndEspecie;

	@Column(name="orccab_cliente_end_numero")
	private String orccabClienteEndNumero;

	@Column(name="orccab_cliente_et_bairro")
	private String orccabClienteEtBairro;

	@Column(name="orccab_cliente_et_cep")
	private String orccabClienteEtCep;

	@Column(name="orccab_cliente_et_complemento")
	private String orccabClienteEtComplemento;

	@Column(name="orccab_cliente_et_endereco")
	private String orccabClienteEtEndereco;

	@Column(name="orccab_cliente_et_especie")
	private String orccabClienteEtEspecie;

	@Column(name="orccab_cliente_et_municipio")
	private String orccabClienteEtMunicipio;

	@Column(name="orccab_cliente_et_numero")
	private String orccabClienteEtNumero;

	@Column(name="orccab_cliente_et_pais")
	private String orccabClienteEtPais;

	@Column(name="orccab_cliente_et_uf")
	private String orccabClienteEtUf;

	@Column(name="orccab_cliente_et_utilizar")
	private boolean orccabClienteEtUtilizar;*/

	private String orccab_cliente_Nome;

	/*@Column(name="orccab_contato")
	private String orccabContato;

	@Column(name="ORCCAB_CONTATO_EMAIL")
	private String orccabContatoEmail;

	@Column(name="OrcCab_data_email")
	private Timestamp orcCab_data_email;

	private Timestamp orccab_Data_preco_Cor;

	private Timestamp orccab_Data_Status;

	@Column(name="orccab_desconto_valor")
	private BigDecimal orccabDescontoValor;

	@Column(name="OrcCab_Diferenca")
	private BigDecimal orcCab_Diferenca;

	@Column(name="orccab_diferenca_valor")
	private BigDecimal orccabDiferencaValor;

	@Column(name="OrcCab_email")
	private Integer orcCab_email;*/

	@Column(name="orccab_emissao")
	private Timestamp orccabEmissao;

	/*@Column(name="orccab_encargos_perc")
	private BigDecimal orccabEncargosPerc;

	@Column(name="orccab_encargos_valor")
	private BigDecimal orccabEncargosValor;

	@Column(name="orccab_fax")
	private String orccabFax;

	@Column(name="orccab_fone")
	private String orccabFone;

	@Column(name="orccab_frete_valor")
	private BigDecimal orccabFreteValor;

	@Column(name="OrcCab_FRETE1")
	private BigDecimal orcCab_FRETE1;

	@Column(name="orccab_gerente")
	private String orccabGerente;

	@Column(name="orccab_ie_rg")
	private String orccabIeRg;

	@Column(name="orccab_ipi_valor")
	private BigDecimal orccabIpiValor;

	private String orccab_Lista;

	@Column(name="orccab_loja")
	private String orccabLoja;

	@Column(name="OrcCab_Montagem")
	private BigDecimal orcCab_Montagem;

	@Column(name="orccab_motivo")
	private String orccabMotivo;

	@Column(name="orccab_municipio")
	private String orccabMunicipio;

	@Column(name="orccab_nova_reforma")
	private String orccabNovaReforma;

	@Column(name="orccab_nr_orc_vnd")
	private String orccabNrOrcVnd;

	@Column(name="orccab_opcao_comissao")
	private String orccabOpcaoComissao;

	@Column(name="orccab_opcao_resumo")
	private String orccabOpcaoResumo;

	@Column(name="orccab_orcamentista")
	private String orccabOrcamentista;

	@Column(name="orccab_pedido")
	private String orccabPedido;

	@Column(name="orccab_pedido_cliente")
	private String orccabPedidoCliente;

	private Timestamp orccab_Pedido_Data;

	private String orccab_Pedido_Usuario;

	@Column(name="OrcCab_Preco_lista_Sem")
	private BigDecimal orcCab_Preco_lista_Sem;

	@Column(name="orccab_projetista")
	private String orccabProjetista;

	@Column(name="orccab_ramo")
	private String orccabRamo;

	@Column(name="ORCCAB_REFERENCIA")
	private String orccabReferencia;

	@Column(name="orccab_revisao")
	private String orccabRevisao;

	@Column(name="orccab_revisao_orc")
	private String orccabRevisaoOrc;

	private Integer orccab_Status;

	@Column(name="orccab_suframa")
	private String orccabSuframa;

	private Integer orccab_Temperatura;

	@Column(name="orccab_total")
	private BigDecimal orccabTotal;

	@Column(name="orccab_total_geral")
	private BigDecimal orccabTotalGeral;

	@Column(name="ORCCAB_TOTAL1")
	private BigDecimal orccabTotal1;

	@Column(name="ORCCAB_TOTAL2")
	private BigDecimal orccabTotal2;

	private String orccab_UF;

	@Column(name="orccab_vendedor")
	private String orccabVendedor;

	@Column(name="orccab_versao_dat")
	private String orccabVersaoDat;

	@Column(name="ORCCAB_VINCULAR")
	private Integer orccabVincular;

	@Column(name="ORCCABDATAENTREGA")
	private Timestamp orccabdataentrega;

	@Column(name="ORCCABDATAFATURAMENTO")
	private Timestamp orccabdatafaturamento;

	@Column(name="ORCCABDATAULTATUALIZACAO")
	private Timestamp orccabdataultatualizacao;

	@Column(name="OrccabFlagImpostos")
	private boolean orccabFlagImpostos;

	@Column(name="OrcCabPrecoLista")
	private BigDecimal orcCabPrecoLista;

	@Column(name="OrccabTextoProposta")
	private String orccabTextoProposta;

	@Column(name="ORCCABTROCARFINAL1")
	private boolean orccabtrocarfinal1;

	@Column(name="ORCCABTROCARFINAL2")
	private boolean orccabtrocarfinal2;

	@Column(name="ORCCABTROCARFINAL3")
	private boolean orccabtrocarfinal3;

	@Column(name="ORCCABTROCARFINAL4")
	private boolean orccabtrocarfinal4;

	@Column(name="ORCCABTROCARFINAL5")
	private boolean orccabtrocarfinal5;

	@Column(name="ORCCABTROCARFINAL6")
	private boolean orccabtrocarfinal6;

	@Column(name="ORCCABVALORBASE1")
	private BigDecimal orccabvalorbase1;

	@Column(name="ORCCABVALORBASE2")
	private BigDecimal orccabvalorbase2;

	@Column(name="ORCCABVALORBASE3")
	private BigDecimal orccabvalorbase3;

	@Column(name="ORCCABVALORBASE4")
	private BigDecimal orccabvalorbase4;

	@Column(name="ORCCABVALORBASE5")
	private BigDecimal orccabvalorbase5;

	@Column(name="ORCCABVALORBASE6")
	private BigDecimal orccabvalorbase6;

	@Column(name="ORCCABVALORFINAL1")
	private BigDecimal orccabvalorfinal1;

	@Column(name="ORCCABVALORFINAL2")
	private BigDecimal orccabvalorfinal2;

	@Column(name="ORCCABVALORFINAL3")
	private BigDecimal orccabvalorfinal3;

	@Column(name="ORCCABVALORFINAL4")
	private BigDecimal orccabvalorfinal4;

	@Column(name="ORCCABVALORFINAL5")
	private BigDecimal orccabvalorfinal5;

	@Column(name="ORCCABVALORFINAL6")
	private BigDecimal orccabvalorfinal6;

	@Column(name="PAISCODIGO")
	private String paiscodigo;

	@Column(name="PgtCabCodigo")
	private String pgtCabCodigo;

	@Column(name="QtdeAlteradas")
	private Integer qtdeAlteradas;

	@Column(name="TipoVenda")
	private String tipoVenda;*/

	@Transient
	private Orclst orclst;
	
	@OneToMany
	@Transient
	private Set<Prdorc> prdOrc;
	
	@OneToMany
	@Transient
	private List<OrcMat> orcMat;
	
	@OneToMany
	@Transient
	private List<OrcItm> orcItm;
	
	@Transient 
	private int count = 0;
	
	public Orccab() {
	}

	public Orccab(String numeroOrcamento, String orccab_cliente_Nome) {
		this.numeroOrcamento = numeroOrcamento;
		this.orccab_cliente_Nome = orccab_cliente_Nome;
	}
	
	public String getNumeroOrcamento() {
		return this.numeroOrcamento.trim();
	}

	public void setNumeroOrcamento(String numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento.trim();
	}

	/*public String getBandeira() {
		return this.bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getComissaoFator() {
		return this.comissaoFator;
	}

	public void setComissaoFator(BigDecimal comissaoFator) {
		this.comissaoFator = comissaoFator;
	}

	public String getConcorrentes() {
		return this.concorrentes;
	}

	public void setConcorrentes(String concorrentes) {
		this.concorrentes = concorrentes;
	}

	public String getCondicaoPagamento() {
		return this.condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public String getCondicaoPagamentoDescricao() {
		return this.condicaoPagamentoDescricao;
	}

	public void setCondicaoPagamentoDescricao(String condicaoPagamentoDescricao) {
		this.condicaoPagamentoDescricao = condicaoPagamentoDescricao;
	}

	public Double getCondicaoPagamentoFator() {
		return this.condicaoPagamentoFator;
	}

	public void setCondicaoPagamentoFator(Double condicaoPagamentoFator) {
		this.condicaoPagamentoFator = condicaoPagamentoFator;
	}

	public String getGrupoImpostos() {
		return this.grupoImpostos;
	}

	public void setGrupoImpostos(String grupoImpostos) {
		this.grupoImpostos = grupoImpostos;
	}

	public String getObservacoesEntrega() {
		return this.observacoesEntrega;
	}

	public void setObservacoesEntrega(String observacoesEntrega) {
		this.observacoesEntrega = observacoesEntrega;
	}

	public String getOrccabAgente() {
		return this.orccabAgente;
	}

	public void setOrccabAgente(String orccabAgente) {
		this.orccabAgente = orccabAgente;
	}

	public BigDecimal getOrccab_Area() {
		return this.orccab_Area;
	}

	public void setOrccab_Area(BigDecimal orccab_Area) {
		this.orccab_Area = orccab_Area;
	}

	public boolean getOrccabBloqueado() {
		return this.orccabBloqueado;
	}

	public void setOrccabBloqueado(boolean orccabBloqueado) {
		this.orccabBloqueado = orccabBloqueado;
	}

	public boolean getOrccabBloquearIcad() {
		return this.orccabBloquearIcad;
	}

	public void setOrccabBloquearIcad(boolean orccabBloquearIcad) {
		this.orccabBloquearIcad = orccabBloquearIcad;
	}*/

	public Timestamp getOrccab_Cadastro() {
		return this.orccab_Cadastro;
	}

	public void setOrccab_Cadastro(Timestamp orccab_Cadastro) {
		this.orccab_Cadastro = orccab_Cadastro;
	}

	/*public String getOrccabCaminhoDwg() {
		return this.orccabCaminhoDwg;
	}

	public void setOrccabCaminhoDwg(String orccabCaminhoDwg) {
		this.orccabCaminhoDwg = orccabCaminhoDwg;
	}

	public String getOrccabChave() {
		return this.orccabChave;
	}

	public void setOrccabChave(String orccabChave) {
		this.orccabChave = orccabChave;
	}

	public String getOrccabClienteBmp() {
		return this.orccabClienteBmp;
	}

	public void setOrccabClienteBmp(String orccabClienteBmp) {
		this.orccabClienteBmp = orccabClienteBmp;
	}

	public String getOrccabClienteCbBairro() {
		return this.orccabClienteCbBairro;
	}

	public void setOrccabClienteCbBairro(String orccabClienteCbBairro) {
		this.orccabClienteCbBairro = orccabClienteCbBairro;
	}

	public String getOrccabClienteCbCep() {
		return this.orccabClienteCbCep;
	}

	public void setOrccabClienteCbCep(String orccabClienteCbCep) {
		this.orccabClienteCbCep = orccabClienteCbCep;
	}

	public String getOrccabClienteCbComplemento() {
		return this.orccabClienteCbComplemento;
	}

	public void setOrccabClienteCbComplemento(String orccabClienteCbComplemento) {
		this.orccabClienteCbComplemento = orccabClienteCbComplemento;
	}

	public String getOrccabClienteCbEndereco() {
		return this.orccabClienteCbEndereco;
	}

	public void setOrccabClienteCbEndereco(String orccabClienteCbEndereco) {
		this.orccabClienteCbEndereco = orccabClienteCbEndereco;
	}

	public String getOrccabClienteCbEspecie() {
		return this.orccabClienteCbEspecie;
	}

	public void setOrccabClienteCbEspecie(String orccabClienteCbEspecie) {
		this.orccabClienteCbEspecie = orccabClienteCbEspecie;
	}

	public String getOrccabClienteCbMunicipio() {
		return this.orccabClienteCbMunicipio;
	}

	public void setOrccabClienteCbMunicipio(String orccabClienteCbMunicipio) {
		this.orccabClienteCbMunicipio = orccabClienteCbMunicipio;
	}

	public String getOrccabClienteCbNumero() {
		return this.orccabClienteCbNumero;
	}

	public void setOrccabClienteCbNumero(String orccabClienteCbNumero) {
		this.orccabClienteCbNumero = orccabClienteCbNumero;
	}

	public String getOrccabClienteCbPais() {
		return this.orccabClienteCbPais;
	}

	public void setOrccabClienteCbPais(String orccabClienteCbPais) {
		this.orccabClienteCbPais = orccabClienteCbPais;
	}

	public String getOrccabClienteCbUf() {
		return this.orccabClienteCbUf;
	}

	public void setOrccabClienteCbUf(String orccabClienteCbUf) {
		this.orccabClienteCbUf = orccabClienteCbUf;
	}

	public boolean getOrccabClienteCbUtilizar() {
		return this.orccabClienteCbUtilizar;
	}

	public void setOrccabClienteCbUtilizar(boolean orccabClienteCbUtilizar) {
		this.orccabClienteCbUtilizar = orccabClienteCbUtilizar;
	}

	public String getOrccab_cliente_CGC_cpf() {
		return this.orccab_cliente_CGC_cpf;
	}

	public void setOrccab_cliente_CGC_cpf(String orccab_cliente_CGC_cpf) {
		this.orccab_cliente_CGC_cpf = orccab_cliente_CGC_cpf;
	}*/

	public Integer getOrccab_cliente_Codigo() {
		return this.orccab_cliente_Codigo;
	}

	public void setOrccab_cliente_Codigo(Integer orccab_cliente_Codigo) {
		this.orccab_cliente_Codigo = orccab_cliente_Codigo;
	}

	public String getOrccabClienteCodinome() {
		return this.orccabClienteCodinome;
	}

	public void setOrccabClienteCodinome(String orccabClienteCodinome) {
		this.orccabClienteCodinome = orccabClienteCodinome;
	}

	/*public String getOrccabClienteEndBairro() {
		return this.orccabClienteEndBairro;
	}

	public void setOrccabClienteEndBairro(String orccabClienteEndBairro) {
		this.orccabClienteEndBairro = orccabClienteEndBairro;
	}

	public String getOrccabClienteEndCep() {
		return this.orccabClienteEndCep;
	}

	public void setOrccabClienteEndCep(String orccabClienteEndCep) {
		this.orccabClienteEndCep = orccabClienteEndCep;
	}

	public String getOrccabClienteEndComplemento() {
		return this.orccabClienteEndComplemento;
	}

	public void setOrccabClienteEndComplemento(String orccabClienteEndComplemento) {
		this.orccabClienteEndComplemento = orccabClienteEndComplemento;
	}

	public String getOrccabClienteEndEndereco() {
		return this.orccabClienteEndEndereco;
	}

	public void setOrccabClienteEndEndereco(String orccabClienteEndEndereco) {
		this.orccabClienteEndEndereco = orccabClienteEndEndereco;
	}

	public String getOrccabClienteEndEspecie() {
		return this.orccabClienteEndEspecie;
	}

	public void setOrccabClienteEndEspecie(String orccabClienteEndEspecie) {
		this.orccabClienteEndEspecie = orccabClienteEndEspecie;
	}

	public String getOrccabClienteEndNumero() {
		return this.orccabClienteEndNumero;
	}

	public void setOrccabClienteEndNumero(String orccabClienteEndNumero) {
		this.orccabClienteEndNumero = orccabClienteEndNumero;
	}

	public String getOrccabClienteEtBairro() {
		return this.orccabClienteEtBairro;
	}

	public void setOrccabClienteEtBairro(String orccabClienteEtBairro) {
		this.orccabClienteEtBairro = orccabClienteEtBairro;
	}

	public String getOrccabClienteEtCep() {
		return this.orccabClienteEtCep;
	}

	public void setOrccabClienteEtCep(String orccabClienteEtCep) {
		this.orccabClienteEtCep = orccabClienteEtCep;
	}

	public String getOrccabClienteEtComplemento() {
		return this.orccabClienteEtComplemento;
	}

	public void setOrccabClienteEtComplemento(String orccabClienteEtComplemento) {
		this.orccabClienteEtComplemento = orccabClienteEtComplemento;
	}

	public String getOrccabClienteEtEndereco() {
		return this.orccabClienteEtEndereco;
	}

	public void setOrccabClienteEtEndereco(String orccabClienteEtEndereco) {
		this.orccabClienteEtEndereco = orccabClienteEtEndereco;
	}

	public String getOrccabClienteEtEspecie() {
		return this.orccabClienteEtEspecie;
	}

	public void setOrccabClienteEtEspecie(String orccabClienteEtEspecie) {
		this.orccabClienteEtEspecie = orccabClienteEtEspecie;
	}

	public String getOrccabClienteEtMunicipio() {
		return this.orccabClienteEtMunicipio;
	}

	public void setOrccabClienteEtMunicipio(String orccabClienteEtMunicipio) {
		this.orccabClienteEtMunicipio = orccabClienteEtMunicipio;
	}

	public String getOrccabClienteEtNumero() {
		return this.orccabClienteEtNumero;
	}

	public void setOrccabClienteEtNumero(String orccabClienteEtNumero) {
		this.orccabClienteEtNumero = orccabClienteEtNumero;
	}

	public String getOrccabClienteEtPais() {
		return this.orccabClienteEtPais;
	}

	public void setOrccabClienteEtPais(String orccabClienteEtPais) {
		this.orccabClienteEtPais = orccabClienteEtPais;
	}

	public String getOrccabClienteEtUf() {
		return this.orccabClienteEtUf;
	}

	public void setOrccabClienteEtUf(String orccabClienteEtUf) {
		this.orccabClienteEtUf = orccabClienteEtUf;
	}

	public boolean getOrccabClienteEtUtilizar() {
		return this.orccabClienteEtUtilizar;
	}

	public void setOrccabClienteEtUtilizar(boolean orccabClienteEtUtilizar) {
		this.orccabClienteEtUtilizar = orccabClienteEtUtilizar;
	}*/

	public String getOrccab_cliente_Nome() {
		return this.orccab_cliente_Nome;
	}

	public void setOrccab_cliente_Nome(String orccab_cliente_Nome) {
		this.orccab_cliente_Nome = orccab_cliente_Nome;
	}

	/*public String getOrccabContato() {
		return this.orccabContato;
	}

	public void setOrccabContato(String orccabContato) {
		this.orccabContato = orccabContato;
	}

	public String getOrccabContatoEmail() {
		return this.orccabContatoEmail;
	}

	public void setOrccabContatoEmail(String orccabContatoEmail) {
		this.orccabContatoEmail = orccabContatoEmail;
	}

	public Timestamp getOrcCab_data_email() {
		return this.orcCab_data_email;
	}

	public void setOrcCab_data_email(Timestamp orcCab_data_email) {
		this.orcCab_data_email = orcCab_data_email;
	}

	public Timestamp getOrccab_Data_preco_Cor() {
		return this.orccab_Data_preco_Cor;
	}

	public void setOrccab_Data_preco_Cor(Timestamp orccab_Data_preco_Cor) {
		this.orccab_Data_preco_Cor = orccab_Data_preco_Cor;
	}

	public Timestamp getOrccab_Data_Status() {
		return this.orccab_Data_Status;
	}

	public void setOrccab_Data_Status(Timestamp orccab_Data_Status) {
		this.orccab_Data_Status = orccab_Data_Status;
	}

	public BigDecimal getOrccabDescontoValor() {
		return this.orccabDescontoValor;
	}

	public void setOrccabDescontoValor(BigDecimal orccabDescontoValor) {
		this.orccabDescontoValor = orccabDescontoValor;
	}

	public BigDecimal getOrcCab_Diferenca() {
		return this.orcCab_Diferenca;
	}

	public void setOrcCab_Diferenca(BigDecimal orcCab_Diferenca) {
		this.orcCab_Diferenca = orcCab_Diferenca;
	}*/

	/*public BigDecimal getOrccabDiferencaValor() {
		return this.orccabDiferencaValor;
	}

	public void setOrccabDiferencaValor(BigDecimal orccabDiferencaValor) {
		this.orccabDiferencaValor = orccabDiferencaValor;
	}

	public Integer getOrcCab_email() {
		return this.orcCab_email;
	}

	public void setOrcCab_email(Integer orcCab_email) {
		this.orcCab_email = orcCab_email;
	}*/

	public Timestamp getOrccabEmissao() {
		return this.orccabEmissao;
	}

	public void setOrccabEmissao(Timestamp orccabEmissao) {
		this.orccabEmissao = orccabEmissao;
	}

	/*public BigDecimal getOrccabEncargosPerc() {
		return this.orccabEncargosPerc;
	}

	public void setOrccabEncargosPerc(BigDecimal orccabEncargosPerc) {
		this.orccabEncargosPerc = orccabEncargosPerc;
	}

	public BigDecimal getOrccabEncargosValor() {
		return this.orccabEncargosValor;
	}

	public void setOrccabEncargosValor(BigDecimal orccabEncargosValor) {
		this.orccabEncargosValor = orccabEncargosValor;
	}

	public String getOrccabFax() {
		return this.orccabFax;
	}

	public void setOrccabFax(String orccabFax) {
		this.orccabFax = orccabFax;
	}

	public String getOrccabFone() {
		return this.orccabFone;
	}

	public void setOrccabFone(String orccabFone) {
		this.orccabFone = orccabFone;
	}

	public BigDecimal getOrccabFreteValor() {
		return this.orccabFreteValor;
	}

	public void setOrccabFreteValor(BigDecimal orccabFreteValor) {
		this.orccabFreteValor = orccabFreteValor;
	}

	public BigDecimal getOrcCab_FRETE1() {
		return this.orcCab_FRETE1;
	}

	public void setOrcCab_FRETE1(BigDecimal orcCab_FRETE1) {
		this.orcCab_FRETE1 = orcCab_FRETE1;
	}

	public String getOrccabGerente() {
		return this.orccabGerente;
	}

	public void setOrccabGerente(String orccabGerente) {
		this.orccabGerente = orccabGerente;
	}

	public String getOrccabIeRg() {
		return this.orccabIeRg;
	}

	public void setOrccabIeRg(String orccabIeRg) {
		this.orccabIeRg = orccabIeRg;
	}

	public BigDecimal getOrccabIpiValor() {
		return this.orccabIpiValor;
	}

	public void setOrccabIpiValor(BigDecimal orccabIpiValor) {
		this.orccabIpiValor = orccabIpiValor;
	}

	public String getOrccab_Lista() {
		return this.orccab_Lista;
	}

	public void setOrccab_Lista(String orccab_Lista) {
		this.orccab_Lista = orccab_Lista;
	}

	public String getOrccabLoja() {
		return this.orccabLoja;
	}

	public void setOrccabLoja(String orccabLoja) {
		this.orccabLoja = orccabLoja;
	}

	public BigDecimal getOrcCab_Montagem() {
		return this.orcCab_Montagem;
	}

	public void setOrcCab_Montagem(BigDecimal orcCab_Montagem) {
		this.orcCab_Montagem = orcCab_Montagem;
	}

	public String getOrccabMotivo() {
		return this.orccabMotivo;
	}

	public void setOrccabMotivo(String orccabMotivo) {
		this.orccabMotivo = orccabMotivo;
	}

	public String getOrccabMunicipio() {
		return this.orccabMunicipio;
	}

	public void setOrccabMunicipio(String orccabMunicipio) {
		this.orccabMunicipio = orccabMunicipio;
	}

	public String getOrccabNovaReforma() {
		return this.orccabNovaReforma;
	}

	public void setOrccabNovaReforma(String orccabNovaReforma) {
		this.orccabNovaReforma = orccabNovaReforma;
	}

	public String getOrccabNrOrcVnd() {
		return this.orccabNrOrcVnd;
	}

	public void setOrccabNrOrcVnd(String orccabNrOrcVnd) {
		this.orccabNrOrcVnd = orccabNrOrcVnd;
	}

	public String getOrccabOpcaoComissao() {
		return this.orccabOpcaoComissao;
	}

	public void setOrccabOpcaoComissao(String orccabOpcaoComissao) {
		this.orccabOpcaoComissao = orccabOpcaoComissao;
	}

	public String getOrccabOpcaoResumo() {
		return this.orccabOpcaoResumo;
	}

	public void setOrccabOpcaoResumo(String orccabOpcaoResumo) {
		this.orccabOpcaoResumo = orccabOpcaoResumo;
	}

	public String getOrccabOrcamentista() {
		return this.orccabOrcamentista;
	}

	public void setOrccabOrcamentista(String orccabOrcamentista) {
		this.orccabOrcamentista = orccabOrcamentista;
	}

	public String getOrccabPedido() {
		return this.orccabPedido;
	}

	public void setOrccabPedido(String orccabPedido) {
		this.orccabPedido = orccabPedido;
	}

	public String getOrccabPedidoCliente() {
		return this.orccabPedidoCliente;
	}

	public void setOrccabPedidoCliente(String orccabPedidoCliente) {
		this.orccabPedidoCliente = orccabPedidoCliente;
	}

	public Timestamp getOrccab_Pedido_Data() {
		return this.orccab_Pedido_Data;
	}

	public void setOrccab_Pedido_Data(Timestamp orccab_Pedido_Data) {
		this.orccab_Pedido_Data = orccab_Pedido_Data;
	}

	public String getOrccab_Pedido_Usuario() {
		return this.orccab_Pedido_Usuario;
	}

	public void setOrccab_Pedido_Usuario(String orccab_Pedido_Usuario) {
		this.orccab_Pedido_Usuario = orccab_Pedido_Usuario;
	}

	public BigDecimal getOrcCab_Preco_lista_Sem() {
		return this.orcCab_Preco_lista_Sem;
	}

	public void setOrcCab_Preco_lista_Sem(BigDecimal orcCab_Preco_lista_Sem) {
		this.orcCab_Preco_lista_Sem = orcCab_Preco_lista_Sem;
	}

	public String getOrccabProjetista() {
		return this.orccabProjetista;
	}

	public void setOrccabProjetista(String orccabProjetista) {
		this.orccabProjetista = orccabProjetista;
	}

	public String getOrccabRamo() {
		return this.orccabRamo;
	}

	public void setOrccabRamo(String orccabRamo) {
		this.orccabRamo = orccabRamo;
	}

	public String getOrccabReferencia() {
		return this.orccabReferencia;
	}

	public void setOrccabReferencia(String orccabReferencia) {
		this.orccabReferencia = orccabReferencia;
	}

	public String getOrccabRevisao() {
		return this.orccabRevisao;
	}

	public void setOrccabRevisao(String orccabRevisao) {
		this.orccabRevisao = orccabRevisao;
	}

	public String getOrccabRevisaoOrc() {
		return this.orccabRevisaoOrc;
	}

	public void setOrccabRevisaoOrc(String orccabRevisaoOrc) {
		this.orccabRevisaoOrc = orccabRevisaoOrc;
	}

	public Integer getOrccab_Status() {
		return this.orccab_Status;
	}

	public void setOrccab_Status(Integer orccab_Status) {
		this.orccab_Status = orccab_Status;
	}

	public String getOrccabSuframa() {
		return this.orccabSuframa;
	}

	public void setOrccabSuframa(String orccabSuframa) {
		this.orccabSuframa = orccabSuframa;
	}

	public Integer getOrccab_Temperatura() {
		return this.orccab_Temperatura;
	}

	public void setOrccab_Temperatura(Integer orccab_Temperatura) {
		this.orccab_Temperatura = orccab_Temperatura;
	}

	public BigDecimal getOrccabTotal() {
		return this.orccabTotal;
	}

	public void setOrccabTotal(BigDecimal orccabTotal) {
		this.orccabTotal = orccabTotal;
	}

	public BigDecimal getOrccabTotalGeral() {
		return this.orccabTotalGeral;
	}

	public void setOrccabTotalGeral(BigDecimal orccabTotalGeral) {
		this.orccabTotalGeral = orccabTotalGeral;
	}

	public BigDecimal getOrccabTotal1() {
		return this.orccabTotal1;
	}

	public void setOrccabTotal1(BigDecimal orccabTotal1) {
		this.orccabTotal1 = orccabTotal1;
	}

	public BigDecimal getOrccabTotal2() {
		return this.orccabTotal2;
	}

	public void setOrccabTotal2(BigDecimal orccabTotal2) {
		this.orccabTotal2 = orccabTotal2;
	}

	public String getOrccab_UF() {
		return this.orccab_UF;
	}

	public void setOrccab_UF(String orccab_UF) {
		this.orccab_UF = orccab_UF;
	}

	public String getOrccabVendedor() {
		return this.orccabVendedor;
	}

	public void setOrccabVendedor(String orccabVendedor) {
		this.orccabVendedor = orccabVendedor;
	}

	public String getOrccabVersaoDat() {
		return this.orccabVersaoDat;
	}

	public void setOrccabVersaoDat(String orccabVersaoDat) {
		this.orccabVersaoDat = orccabVersaoDat;
	}

	public Integer getOrccabVincular() {
		return this.orccabVincular;
	}

	public void setOrccabVincular(Integer orccabVincular) {
		this.orccabVincular = orccabVincular;
	}

	public Timestamp getOrccabdataentrega() {
		return this.orccabdataentrega;
	}

	public void setOrccabdataentrega(Timestamp orccabdataentrega) {
		this.orccabdataentrega = orccabdataentrega;
	}

	public Timestamp getOrccabdatafaturamento() {
		return this.orccabdatafaturamento;
	}

	public void setOrccabdatafaturamento(Timestamp orccabdatafaturamento) {
		this.orccabdatafaturamento = orccabdatafaturamento;
	}

	public Timestamp getOrccabdataultatualizacao() {
		return this.orccabdataultatualizacao;
	}

	public void setOrccabdataultatualizacao(Timestamp orccabdataultatualizacao) {
		this.orccabdataultatualizacao = orccabdataultatualizacao;
	}

	public boolean getOrccabFlagImpostos() {
		return this.orccabFlagImpostos;
	}

	public void setOrccabFlagImpostos(boolean orccabFlagImpostos) {
		this.orccabFlagImpostos = orccabFlagImpostos;
	}

	public BigDecimal getOrcCabPrecoLista() {
		return this.orcCabPrecoLista;
	}

	public void setOrcCabPrecoLista(BigDecimal orcCabPrecoLista) {
		this.orcCabPrecoLista = orcCabPrecoLista;
	}

	public String getOrccabTextoProposta() {
		return this.orccabTextoProposta;
	}

	public void setOrccabTextoProposta(String orccabTextoProposta) {
		this.orccabTextoProposta = orccabTextoProposta;
	}

	public boolean getOrccabtrocarfinal1() {
		return this.orccabtrocarfinal1;
	}

	public void setOrccabtrocarfinal1(boolean orccabtrocarfinal1) {
		this.orccabtrocarfinal1 = orccabtrocarfinal1;
	}

	public boolean getOrccabtrocarfinal2() {
		return this.orccabtrocarfinal2;
	}

	public void setOrccabtrocarfinal2(boolean orccabtrocarfinal2) {
		this.orccabtrocarfinal2 = orccabtrocarfinal2;
	}

	public boolean getOrccabtrocarfinal3() {
		return this.orccabtrocarfinal3;
	}

	public void setOrccabtrocarfinal3(boolean orccabtrocarfinal3) {
		this.orccabtrocarfinal3 = orccabtrocarfinal3;
	}

	public boolean getOrccabtrocarfinal4() {
		return this.orccabtrocarfinal4;
	}

	public void setOrccabtrocarfinal4(boolean orccabtrocarfinal4) {
		this.orccabtrocarfinal4 = orccabtrocarfinal4;
	}

	public boolean getOrccabtrocarfinal5() {
		return this.orccabtrocarfinal5;
	}

	public void setOrccabtrocarfinal5(boolean orccabtrocarfinal5) {
		this.orccabtrocarfinal5 = orccabtrocarfinal5;
	}

	public boolean getOrccabtrocarfinal6() {
		return this.orccabtrocarfinal6;
	}

	public void setOrccabtrocarfinal6(boolean orccabtrocarfinal6) {
		this.orccabtrocarfinal6 = orccabtrocarfinal6;
	}

	public BigDecimal getOrccabvalorbase1() {
		return this.orccabvalorbase1;
	}

	public void setOrccabvalorbase1(BigDecimal orccabvalorbase1) {
		this.orccabvalorbase1 = orccabvalorbase1;
	}

	public BigDecimal getOrccabvalorbase2() {
		return this.orccabvalorbase2;
	}

	public void setOrccabvalorbase2(BigDecimal orccabvalorbase2) {
		this.orccabvalorbase2 = orccabvalorbase2;
	}

	public BigDecimal getOrccabvalorbase3() {
		return this.orccabvalorbase3;
	}

	public void setOrccabvalorbase3(BigDecimal orccabvalorbase3) {
		this.orccabvalorbase3 = orccabvalorbase3;
	}

	public BigDecimal getOrccabvalorbase4() {
		return this.orccabvalorbase4;
	}

	public void setOrccabvalorbase4(BigDecimal orccabvalorbase4) {
		this.orccabvalorbase4 = orccabvalorbase4;
	}

	public BigDecimal getOrccabvalorbase5() {
		return this.orccabvalorbase5;
	}

	public void setOrccabvalorbase5(BigDecimal orccabvalorbase5) {
		this.orccabvalorbase5 = orccabvalorbase5;
	}

	public BigDecimal getOrccabvalorbase6() {
		return this.orccabvalorbase6;
	}

	public void setOrccabvalorbase6(BigDecimal orccabvalorbase6) {
		this.orccabvalorbase6 = orccabvalorbase6;
	}

	public BigDecimal getOrccabvalorfinal1() {
		return this.orccabvalorfinal1;
	}

	public void setOrccabvalorfinal1(BigDecimal orccabvalorfinal1) {
		this.orccabvalorfinal1 = orccabvalorfinal1;
	}

	public BigDecimal getOrccabvalorfinal2() {
		return this.orccabvalorfinal2;
	}

	public void setOrccabvalorfinal2(BigDecimal orccabvalorfinal2) {
		this.orccabvalorfinal2 = orccabvalorfinal2;
	}

	public BigDecimal getOrccabvalorfinal3() {
		return this.orccabvalorfinal3;
	}

	public void setOrccabvalorfinal3(BigDecimal orccabvalorfinal3) {
		this.orccabvalorfinal3 = orccabvalorfinal3;
	}

	public BigDecimal getOrccabvalorfinal4() {
		return this.orccabvalorfinal4;
	}

	public void setOrccabvalorfinal4(BigDecimal orccabvalorfinal4) {
		this.orccabvalorfinal4 = orccabvalorfinal4;
	}

	public BigDecimal getOrccabvalorfinal5() {
		return this.orccabvalorfinal5;
	}

	public void setOrccabvalorfinal5(BigDecimal orccabvalorfinal5) {
		this.orccabvalorfinal5 = orccabvalorfinal5;
	}

	public BigDecimal getOrccabvalorfinal6() {
		return this.orccabvalorfinal6;
	}

	public void setOrccabvalorfinal6(BigDecimal orccabvalorfinal6) {
		this.orccabvalorfinal6 = orccabvalorfinal6;
	}

	public String getPaiscodigo() {
		return this.paiscodigo;
	}

	public void setPaiscodigo(String paiscodigo) {
		this.paiscodigo = paiscodigo;
	}

	public String getPgtCabCodigo() {
		return this.pgtCabCodigo;
	}

	public void setPgtCabCodigo(String pgtCabCodigo) {
		this.pgtCabCodigo = pgtCabCodigo;
	}

	public Integer getQtdeAlteradas() {
		return this.qtdeAlteradas;
	}

	public void setQtdeAlteradas(Integer qtdeAlteradas) {
		this.qtdeAlteradas = qtdeAlteradas;
	}

	public String getTipoVenda() {
		return this.tipoVenda;
	}

	public void setTipoVenda(String tipoVenda) {
		this.tipoVenda = tipoVenda;
	}*/

	public Orclst getOrclst() {
		return orclst;
	}

	public void setOrclst(Orclst orclst) {
		this.orclst = orclst;
	}

	public Set<Prdorc> getPrdOrc() {
		return prdOrc;
	}

	public void setPrdOrc(Set<Prdorc> prdOrc) {
		this.prdOrc = prdOrc;
	}

	public List<OrcMat> getOrcMat() {
		return orcMat;
	}

	public void setOrcMat(List<OrcMat> orcMat) {
		this.orcMat = orcMat;
	}

	@Transient
	public List<OrcItm> getOrcItm() {
		return orcItm;
	}

	@Transient
	public void setOrcItm(List<OrcItm> orcItm) {
		this.orcItm = orcItm;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("ORCCAB: %s %s, Situacao: %d\n", this.getNumeroOrcamento().trim(), this.getOrccab_cliente_Nome() == null ? "" : this.getOrccab_cliente_Nome().trim(), this.getOrclst().getOrclstStatus()));
		String margin = " ";

		buf.append(" +-----------------------------------------------------------------------------------------------+\n");
		buf.append(" |                                            ITEMS                                              |\n");
		buf.append(" +-----------------------------------------------------------------------------------------------+\n");

		for(OrcItm itm : this.orcItm) {
			buf.append(itm.toString(margin));
		}		

		buf.append(" +-----------------------------------------------------------------------------------------------+\n");
		buf.append(" |                                           PRODUTOS                                            |\n");
		buf.append(" +-----------------------------------------------------------------------------------------------+\n");

		for(Prdorc prdorc : this.prdOrc) {
			buf.append(prdorc.toString(margin));
		}		
		
		buf.append(" +-----------------------------------------------------------------------------------------------+\n");
		buf.append(" |                                          MATERIAIS                                            |\n");
		buf.append(" +-----------------------------------------------------------------------------------------------+\n");
		
		for(OrcMat mat : this.orcMat) {
			buf.append(mat.toString(margin));
		}
		
		buf.append(String.format("\n    Acessos na tabela PrdOrc: %d\n    Quant. Produtos: %d\n    Quant. Materiais: %d\n    Quant. Items: %d", 
				this.getCount(), this.prdOrc.size(), this.orcMat.size(), this.orcItm.size()));

		return buf.toString();		
	}

	public int getCount() {
		return count;
	}

	public void setCount() {
		this.count++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroOrcamento == null) ? 0 : numeroOrcamento.hashCode());
		result = prime
				* result
				+ ((orccab_cliente_Nome == null) ? 0 : orccab_cliente_Nome
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orccab other = (Orccab) obj;
		if (numeroOrcamento == null) {
			if (other.numeroOrcamento != null)
				return false;
		} else if (!numeroOrcamento.equals(other.numeroOrcamento))
			return false;
		if (orccab_cliente_Nome == null) {
			if (other.orccab_cliente_Nome != null)
				return false;
		} else if (!orccab_cliente_Nome.equals(other.orccab_cliente_Nome))
			return false;
		return true;
	}

}