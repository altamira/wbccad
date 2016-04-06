package br.com.altamira.data.wbccad.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alessandro.holanda
 */
@Entity
public class Orclst implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "orclst_numero", nullable = false, length = 40)
    private String orclstNumero;
    
    @Basic(optional = false)
    @Column(name = "orclst_status", nullable = false)
    private int orclstStatus;
    
    @Column(name = "orclst_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstCadastro;
    
    @Column(name = "orclst_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstEmissao;
    
    @Column(name = "orclst_contato", length = 2147483647)
    private String orclstContato;
    
    @Column(name = "orclst_loja", length = 50)
    private String orclstLoja;
    
    @Column(name = "orclst_municipio", length = 23)
    private String orclstMunicipio;
    
    @Column(name = "orclst_uf", length = 2)
    private String orclstUf;
    
    @Column(name = "orclst_area")
    private Integer orclstArea;
    
    @Column(name = "orclst_planta", length = 1)
    private String orclstPlanta;
    
    @Column(name = "orclst_corte", length = 1)
    private String orclstCorte;
    
    @Column(name = "orclst_orcamento", length = 1)
    private String orclstOrcamento;
    
    @Column(name = "orclst_nr_orc_vnd", length = 10)
    private String orclstNrOrcVnd;
    
    @Column(name = "orclst_lista", length = 20)
    private String orclstLista;
    
    @Column(name = "orclst_revisao", length = 1)
    private String orclstRevisao;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orclst_total", precision = 53)
    private Double orclstTotal;
    
    @Column(name = "orclst_nova_reforma", length = 1)
    private String orclstNovaReforma;
    
    @Column(name = "orclst_versao_dat", length = 10)
    private String orclstVersaoDat;
    
    @Column(name = "orclst_cli_codigo")
    private Integer orclstCliCodigo;
    
    @Column(name = "orclst_cli_nome", length = 50)
    private String orclstCliNome;
    
    @Column(name = "orclst_cli_cgc_cpf", length = 18)
    private String orclstCliCgcCpf;
    
    @Column(name = "orclst_cli_end_especie", length = 4)
    private String orclstCliEndEspecie;
    
    @Column(name = "orclst_cli_end_endereco", length = 50)
    private String orclstCliEndEndereco;
    
    @Column(name = "orclst_cli_end_numero", length = 6)
    private String orclstCliEndNumero;
    
    @Column(name = "orclst_cli_end_bairro", length = 30)
    private String orclstCliEndBairro;
    
    @Column(name = "orclst_cli_end_cep", length = 9)
    private String orclstCliEndCep;
    
    @Column(name = "orclst_cli_end_complemento", length = 30)
    private String orclstCliEndComplemento;
    
    @Column(name = "orclst_cli_bmp", length = 255)
    private String orclstCliBmp;
    
    @Column(name = "orclst_data_status")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstDataStatus;
    
    @Column(name = "orclst_revisao_orc", length = 1)
    private String orclstRevisaoOrc;
    
    @Column(name = "orclst_temperatura")
    private Integer orclstTemperatura;
    
    @Column(name = "orclst_motivo", length = 40)
    private String orclstMotivo;
    
    @Column(name = "orclst_caminho_dwg", length = 255)
    private String orclstCaminhoDwg;
    
    @Column(name = "orclst_pedido", length = 15)
    private String orclstPedido;
    
    @Column(name = "orclst_pedido_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstPedidoData;
    
    @Column(name = "orclst_pedido_usuario", length = 255)
    private String orclstPedidoUsuario;
    
    @Column(name = "orclst_dataImportacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstdataImportacao;
    
    @Column(name = "orclst_email")
    private Boolean orclstEmail;
    
    @Column(name = "orclst_data_email")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstDataEmail;
    
    @Column(name = "orclst_opcao_comissao", length = 50)
    private String orclstOpcaoComissao;
    
    @Column(name = "OrcLst_EmUsoPor", length = 50)
    private String orcLstEmUsoPor;
    
    @Column(name = "OrcLst_Computador", length = 50)
    private String orcLstComputador;
    
    @Column(length = 50)
    private String bandeira;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstdataultatualizacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstdatafaturamento;
    
    @Column(name = "COMISSAO_FATOR", precision = 19, scale = 4)
    private BigDecimal comissaoFator;
    
    @Column(name = "ORCLST_REFERENCIA", length = 40)
    private String orclstReferencia;
    
    @Column(name = "ORCLST_TOTAL1", precision = 19, scale = 4)
    private BigDecimal orclstTotal1;
    
    @Column(name = "ORCLST_TOTAL2", precision = 19, scale = 4)
    private BigDecimal orclstTotal2;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstdataentrega;
    
    @Column(name = "ORCLST_IMPORTACAO_LISTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orclstImportacaoLista;
    
    @Column(name = "ORCLST_GERENTE", length = 50)
    private String orclstGerente;
    
    @Column(name = "ORCLST_VENDEDOR", length = 50)
    private String orclstVendedor;
    
    @Column(name = "ORCLST_PROJETISTA", length = 50)
    private String orclstProjetista;
    
    @Column(name = "ORCLST_ORCAMENTISTA", length = 50)
    private String orclstOrcamentista;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private int idOrcLst;
    
    @Column(name = "ORCLST_AGENTE", length = 60)
    private String orclstAgente;
    
    @Column(name = "ORCLST_TOTAL_LISTA", precision = 19, scale = 4)
    private BigDecimal orclstTotalLista;

    public Orclst() {
    }

    public Orclst(String orclstNumero) {
        this.orclstNumero = orclstNumero;
    }

    public Orclst(String orclstNumero, int orclstStatus, int idOrcLst) {
        this.orclstNumero = orclstNumero;
        this.orclstStatus = orclstStatus;
        this.idOrcLst = idOrcLst;
    }

    public String getOrclstNumero() {
        return orclstNumero;
    }

    public void setOrclstNumero(String orclstNumero) {
        this.orclstNumero = orclstNumero;
    }

    public int getOrclstStatus() {
        return orclstStatus;
    }

    public void setOrclstStatus(int orclstStatus) {
        this.orclstStatus = orclstStatus;
    }

    public Date getOrclstCadastro() {
        return orclstCadastro;
    }

    public void setOrclstCadastro(Date orclstCadastro) {
        this.orclstCadastro = orclstCadastro;
    }

    public Date getOrclstEmissao() {
        return orclstEmissao;
    }

    public void setOrclstEmissao(Date orclstEmissao) {
        this.orclstEmissao = orclstEmissao;
    }

    public String getOrclstContato() {
        return orclstContato;
    }

    public void setOrclstContato(String orclstContato) {
        this.orclstContato = orclstContato;
    }

    public String getOrclstLoja() {
        return orclstLoja;
    }

    public void setOrclstLoja(String orclstLoja) {
        this.orclstLoja = orclstLoja;
    }

    public String getOrclstMunicipio() {
        return orclstMunicipio;
    }

    public void setOrclstMunicipio(String orclstMunicipio) {
        this.orclstMunicipio = orclstMunicipio;
    }

    public String getOrclstUf() {
        return orclstUf;
    }

    public void setOrclstUf(String orclstUf) {
        this.orclstUf = orclstUf;
    }

    public Integer getOrclstArea() {
        return orclstArea;
    }

    public void setOrclstArea(Integer orclstArea) {
        this.orclstArea = orclstArea;
    }

    public String getOrclstPlanta() {
        return orclstPlanta;
    }

    public void setOrclstPlanta(String orclstPlanta) {
        this.orclstPlanta = orclstPlanta;
    }

    public String getOrclstCorte() {
        return orclstCorte;
    }

    public void setOrclstCorte(String orclstCorte) {
        this.orclstCorte = orclstCorte;
    }

    public String getOrclstOrcamento() {
        return orclstOrcamento;
    }

    public void setOrclstOrcamento(String orclstOrcamento) {
        this.orclstOrcamento = orclstOrcamento;
    }

    public String getOrclstNrOrcVnd() {
        return orclstNrOrcVnd;
    }

    public void setOrclstNrOrcVnd(String orclstNrOrcVnd) {
        this.orclstNrOrcVnd = orclstNrOrcVnd;
    }

    public String getOrclstLista() {
        return orclstLista;
    }

    public void setOrclstLista(String orclstLista) {
        this.orclstLista = orclstLista;
    }

    public String getOrclstRevisao() {
        return orclstRevisao;
    }

    public void setOrclstRevisao(String orclstRevisao) {
        this.orclstRevisao = orclstRevisao;
    }

    public Double getOrclstTotal() {
        return orclstTotal;
    }

    public void setOrclstTotal(Double orclstTotal) {
        this.orclstTotal = orclstTotal;
    }

    public String getOrclstNovaReforma() {
        return orclstNovaReforma;
    }

    public void setOrclstNovaReforma(String orclstNovaReforma) {
        this.orclstNovaReforma = orclstNovaReforma;
    }

    public String getOrclstVersaoDat() {
        return orclstVersaoDat;
    }

    public void setOrclstVersaoDat(String orclstVersaoDat) {
        this.orclstVersaoDat = orclstVersaoDat;
    }

    public Integer getOrclstCliCodigo() {
        return orclstCliCodigo;
    }

    public void setOrclstCliCodigo(Integer orclstCliCodigo) {
        this.orclstCliCodigo = orclstCliCodigo;
    }

    public String getOrclstCliNome() {
        return orclstCliNome;
    }

    public void setOrclstCliNome(String orclstCliNome) {
        this.orclstCliNome = orclstCliNome;
    }

    public String getOrclstCliCgcCpf() {
        return orclstCliCgcCpf;
    }

    public void setOrclstCliCgcCpf(String orclstCliCgcCpf) {
        this.orclstCliCgcCpf = orclstCliCgcCpf;
    }

    public String getOrclstCliEndEspecie() {
        return orclstCliEndEspecie;
    }

    public void setOrclstCliEndEspecie(String orclstCliEndEspecie) {
        this.orclstCliEndEspecie = orclstCliEndEspecie;
    }

    public String getOrclstCliEndEndereco() {
        return orclstCliEndEndereco;
    }

    public void setOrclstCliEndEndereco(String orclstCliEndEndereco) {
        this.orclstCliEndEndereco = orclstCliEndEndereco;
    }

    public String getOrclstCliEndNumero() {
        return orclstCliEndNumero;
    }

    public void setOrclstCliEndNumero(String orclstCliEndNumero) {
        this.orclstCliEndNumero = orclstCliEndNumero;
    }

    public String getOrclstCliEndBairro() {
        return orclstCliEndBairro;
    }

    public void setOrclstCliEndBairro(String orclstCliEndBairro) {
        this.orclstCliEndBairro = orclstCliEndBairro;
    }

    public String getOrclstCliEndCep() {
        return orclstCliEndCep;
    }

    public void setOrclstCliEndCep(String orclstCliEndCep) {
        this.orclstCliEndCep = orclstCliEndCep;
    }

    public String getOrclstCliEndComplemento() {
        return orclstCliEndComplemento;
    }

    public void setOrclstCliEndComplemento(String orclstCliEndComplemento) {
        this.orclstCliEndComplemento = orclstCliEndComplemento;
    }

    public String getOrclstCliBmp() {
        return orclstCliBmp;
    }

    public void setOrclstCliBmp(String orclstCliBmp) {
        this.orclstCliBmp = orclstCliBmp;
    }

    public Date getOrclstDataStatus() {
        return orclstDataStatus;
    }

    public void setOrclstDataStatus(Date orclstDataStatus) {
        this.orclstDataStatus = orclstDataStatus;
    }

    public String getOrclstRevisaoOrc() {
        return orclstRevisaoOrc;
    }

    public void setOrclstRevisaoOrc(String orclstRevisaoOrc) {
        this.orclstRevisaoOrc = orclstRevisaoOrc;
    }

    public Integer getOrclstTemperatura() {
        return orclstTemperatura;
    }

    public void setOrclstTemperatura(Integer orclstTemperatura) {
        this.orclstTemperatura = orclstTemperatura;
    }

    public String getOrclstMotivo() {
        return orclstMotivo;
    }

    public void setOrclstMotivo(String orclstMotivo) {
        this.orclstMotivo = orclstMotivo;
    }

    public String getOrclstCaminhoDwg() {
        return orclstCaminhoDwg;
    }

    public void setOrclstCaminhoDwg(String orclstCaminhoDwg) {
        this.orclstCaminhoDwg = orclstCaminhoDwg;
    }

    public String getOrclstPedido() {
        return orclstPedido;
    }

    public void setOrclstPedido(String orclstPedido) {
        this.orclstPedido = orclstPedido;
    }

    public Date getOrclstPedidoData() {
        return orclstPedidoData;
    }

    public void setOrclstPedidoData(Date orclstPedidoData) {
        this.orclstPedidoData = orclstPedidoData;
    }

    public String getOrclstPedidoUsuario() {
        return orclstPedidoUsuario;
    }

    public void setOrclstPedidoUsuario(String orclstPedidoUsuario) {
        this.orclstPedidoUsuario = orclstPedidoUsuario;
    }

    public Date getOrclstdataImportacao() {
        return orclstdataImportacao;
    }

    public void setOrclstdataImportacao(Date orclstdataImportacao) {
        this.orclstdataImportacao = orclstdataImportacao;
    }

    public Boolean getOrclstEmail() {
        return orclstEmail;
    }

    public void setOrclstEmail(Boolean orclstEmail) {
        this.orclstEmail = orclstEmail;
    }

    public Date getOrclstDataEmail() {
        return orclstDataEmail;
    }

    public void setOrclstDataEmail(Date orclstDataEmail) {
        this.orclstDataEmail = orclstDataEmail;
    }

    public String getOrclstOpcaoComissao() {
        return orclstOpcaoComissao;
    }

    public void setOrclstOpcaoComissao(String orclstOpcaoComissao) {
        this.orclstOpcaoComissao = orclstOpcaoComissao;
    }

    public String getOrcLstEmUsoPor() {
        return orcLstEmUsoPor;
    }

    public void setOrcLstEmUsoPor(String orcLstEmUsoPor) {
        this.orcLstEmUsoPor = orcLstEmUsoPor;
    }

    public String getOrcLstComputador() {
        return orcLstComputador;
    }

    public void setOrcLstComputador(String orcLstComputador) {
        this.orcLstComputador = orcLstComputador;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Date getOrclstdataultatualizacao() {
        return orclstdataultatualizacao;
    }

    public void setOrclstdataultatualizacao(Date orclstdataultatualizacao) {
        this.orclstdataultatualizacao = orclstdataultatualizacao;
    }

    public Date getOrclstdatafaturamento() {
        return orclstdatafaturamento;
    }

    public void setOrclstdatafaturamento(Date orclstdatafaturamento) {
        this.orclstdatafaturamento = orclstdatafaturamento;
    }

    public BigDecimal getComissaoFator() {
        return comissaoFator;
    }

    public void setComissaoFator(BigDecimal comissaoFator) {
        this.comissaoFator = comissaoFator;
    }

    public String getOrclstReferencia() {
        return orclstReferencia;
    }

    public void setOrclstReferencia(String orclstReferencia) {
        this.orclstReferencia = orclstReferencia;
    }

    public BigDecimal getOrclstTotal1() {
        return orclstTotal1;
    }

    public void setOrclstTotal1(BigDecimal orclstTotal1) {
        this.orclstTotal1 = orclstTotal1;
    }

    public BigDecimal getOrclstTotal2() {
        return orclstTotal2;
    }

    public void setOrclstTotal2(BigDecimal orclstTotal2) {
        this.orclstTotal2 = orclstTotal2;
    }

    public Date getOrclstdataentrega() {
        return orclstdataentrega;
    }

    public void setOrclstdataentrega(Date orclstdataentrega) {
        this.orclstdataentrega = orclstdataentrega;
    }

    public Date getOrclstImportacaoLista() {
        return orclstImportacaoLista;
    }

    public void setOrclstImportacaoLista(Date orclstImportacaoLista) {
        this.orclstImportacaoLista = orclstImportacaoLista;
    }

    public String getOrclstGerente() {
        return orclstGerente;
    }

    public void setOrclstGerente(String orclstGerente) {
        this.orclstGerente = orclstGerente;
    }

    public String getOrclstVendedor() {
        return orclstVendedor;
    }

    public void setOrclstVendedor(String orclstVendedor) {
        this.orclstVendedor = orclstVendedor;
    }

    public String getOrclstProjetista() {
        return orclstProjetista;
    }

    public void setOrclstProjetista(String orclstProjetista) {
        this.orclstProjetista = orclstProjetista;
    }

    public String getOrclstOrcamentista() {
        return orclstOrcamentista;
    }

    public void setOrclstOrcamentista(String orclstOrcamentista) {
        this.orclstOrcamentista = orclstOrcamentista;
    }

    public int getIdOrcLst() {
        return idOrcLst;
    }

    public void setIdOrcLst(int idOrcLst) {
        this.idOrcLst = idOrcLst;
    }

    public String getOrclstAgente() {
        return orclstAgente;
    }

    public void setOrclstAgente(String orclstAgente) {
        this.orclstAgente = orclstAgente;
    }

    public BigDecimal getOrclstTotalLista() {
        return orclstTotalLista;
    }

    public void setOrclstTotalLista(BigDecimal orclstTotalLista) {
        this.orclstTotalLista = orclstTotalLista;
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orclstNumero == null) ? 0 : orclstNumero.hashCode());
		result = prime * result
				+ ((orclstRevisao == null) ? 0 : orclstRevisao.hashCode());
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
		Orclst other = (Orclst) obj;
		if (orclstNumero == null) {
			if (other.orclstNumero != null)
				return false;
		} else if (!orclstNumero.equals(other.orclstNumero))
			return false;
		if (orclstRevisao == null) {
			if (other.orclstRevisao != null)
				return false;
		} else if (!orclstRevisao.equals(other.orclstRevisao))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Orcamento: [" + orclstNumero + " ]";
    }
    
}
