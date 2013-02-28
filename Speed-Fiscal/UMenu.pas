unit UMenu;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Buttons, Menus, ExtCtrls;

type
  TForm4 = class(TForm)
    Panel1: TPanel;
    MainMenu1: TMainMenu;
    Cadastros1: TMenuItem;
    SpeedButton4: TSpeedButton;
    SpeedButton8: TSpeedButton;
    SpeedButton10: TSpeedButton;
    SpeedButton11: TSpeedButton;
    SpeedButton12: TSpeedButton;
    SpeedButton14: TSpeedButton;
    Financeiro1: TMenuItem;
    ipoTitulo1: TMenuItem;
    Empresa1: TMenuItem;
    Empresa2: TMenuItem;
    Filial1: TMenuItem;
    ClienteFornecedor1: TMenuItem;
    ClienteFornecedor2: TMenuItem;
    ProdutoServio1: TMenuItem;
    ProdutoServio2: TMenuItem;
    Entradas1: TMenuItem;
    NotaEntrada1: TMenuItem;
    NotaEntrada2: TMenuItem;
    ContaCorrente1: TMenuItem;
    ContaCorrente2: TMenuItem;
    Sintegra1: TMenuItem;
    Sintegra2: TMenuItem;
    EntradaSintegra1: TMenuItem;
    esouraria1: TMenuItem;
    LancarCaixa1: TMenuItem;
    Financeiro2: TMenuItem;
    BaixaTitulo1: TMenuItem;
    Movimentodiario1: TMenuItem;
    CadastroTitulo1: TMenuItem;
    AprovarTitulo1: TMenuItem;
    Vendasvendedoras1: TMenuItem;
    CadastroTitulos1: TMenuItem;
    VariosTitulos1: TMenuItem;
    Gesto1: TMenuItem;
    AlterarPreo1: TMenuItem;
    ConsultarNF1: TMenuItem;
    Aprovartitulos21: TMenuItem;
    ConsultaNf11: TMenuItem;
    ConsultaNf21: TMenuItem;
    Relatoriovendedora1: TMenuItem;
    ConsultaNf31: TMenuItem;
    Etiqueta1: TMenuItem;
    Etiqueta2: TMenuItem;
    Etiqueta3: TMenuItem;
    CentrodeCusto1: TMenuItem;
    CentrodeCusto2: TMenuItem;
    Contador1: TMenuItem;
    Grupo1: TMenuItem;
    SubGrupo1: TMenuItem;
    SpeedButton7: TSpeedButton;
    Saidas1: TMenuItem;
    lanarsaidas1: TMenuItem;
    Marca1: TMenuItem;
    RelatoriodeCdiario1: TMenuItem;
    RelSaidasCupons1: TMenuItem;
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
    procedure SpeedButton4Click(Sender: TObject);
    procedure SpeedButton5Click(Sender: TObject);
    procedure SpeedButton7Click(Sender: TObject);
    procedure SpeedButton8Click(Sender: TObject);
    procedure SpeedButton9Click(Sender: TObject);
    procedure SpeedButton10Click(Sender: TObject);
    procedure SpeedButton11Click(Sender: TObject);
    procedure SpeedButton12Click(Sender: TObject);
    procedure SpeedButton13Click(Sender: TObject);
    procedure SpeedButton14Click(Sender: TObject);
    procedure SpeedButton15Click(Sender: TObject);
    procedure SpeedButton21Click(Sender: TObject);
    procedure SpeedButton22Click(Sender: TObject);
    procedure SpeedButton24Click(Sender: TObject);
    procedure SpeedButton25Click(Sender: TObject);
    procedure ipoTitulo1Click(Sender: TObject);
    procedure Empresa2Click(Sender: TObject);
    procedure ClienteFornecedor2Click(Sender: TObject);
    procedure ProdutoServio2Click(Sender: TObject);
    procedure NotaEntrada2Click(Sender: TObject);
    procedure EntradaSintegra1Click(Sender: TObject);
    procedure BaixaTitulo1Click(Sender: TObject);
    procedure Movimentodiario1Click(Sender: TObject);
    procedure Vendasvendedoras1Click(Sender: TObject);
    procedure CadastroTitulos1Click(Sender: TObject);
    procedure VariosTitulos1Click(Sender: TObject);
    procedure AlterarPreo1Click(Sender: TObject);
    procedure Aprovartitulos11Click(Sender: TObject);
    procedure Aprovartitulos21Click(Sender: TObject);
    procedure ConsultaNf11Click(Sender: TObject);
    procedure ConsultaNf21Click(Sender: TObject);
    procedure Relatoriovendedora1Click(Sender: TObject);
    procedure ConsultaNf31Click(Sender: TObject);
    procedure Etiqueta3Click(Sender: TObject);
    procedure CentrodeCusto2Click(Sender: TObject);
    procedure ContaCorrente2Click(Sender: TObject);
    procedure Contador1Click(Sender: TObject);
    procedure Grupo1Click(Sender: TObject);
    procedure SubGrupo1Click(Sender: TObject);
    procedure lanarsaidas1Click(Sender: TObject);
    procedure Marca1Click(Sender: TObject);
    procedure RelatoriodeCdiario1Click(Sender: TObject);
    procedure resClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form4: TForm4;

implementation

uses UFORMFORMCLIE, UFrmEmpresa, UFormCadProServ, UFormModelo, Unit8,
  UFormCadCCorrente, Unit82, Unit10, Unit100, Unit400, Unit500, Unit600,
  Unit700, Unit800, UAltPrec, Unit315, Unit115, Unit216, Unit108, Unit98,
  Unit73, UFrmCentroCusto, UFrmCadCONTC, UFrmCadContador, UFrmCadGrupo,
  UFrmCadSubGrupo, UFrmCadTipoT, UCadVendDiario, Unit83, UFrmMarca,
  URelCaixaDiario, URelCaixaDiario1, URelApuracao;

{$R *.dfm}

procedure TForm4.SpeedButton1Click(Sender: TObject);
begin
Form2.Show;
end;

procedure TForm4.SpeedButton2Click(Sender: TObject);
begin
Form10.Show;
end;

procedure TForm4.SpeedButton3Click(Sender: TObject);
begin
FRMCADPROD.Show;
end;

procedure TForm4.SpeedButton4Click(Sender: TObject);
begin
Form7.Show;
end;

procedure TForm4.SpeedButton5Click(Sender: TObject);
begin
Form82.Show;
end;

procedure TForm4.SpeedButton7Click(Sender: TObject);
begin
Close();
end;

procedure TForm4.SpeedButton8Click(Sender: TObject);
begin
FrmCadMovD.Show;
end;

procedure TForm4.SpeedButton9Click(Sender: TObject);
begin
FrmBaixaTitulo.Show;
end;

procedure TForm4.SpeedButton10Click(Sender: TObject);
begin
FrmCadTitulos.Show;
end;

procedure TForm4.SpeedButton11Click(Sender: TObject);
begin
FrmAprovPag.Show;


end;

procedure TForm4.SpeedButton12Click(Sender: TObject);
begin
frmlancVendasVend.Show;
end;

procedure TForm4.SpeedButton13Click(Sender: TObject);
begin
FrmCadTitPa.Show;
end;

procedure TForm4.SpeedButton14Click(Sender: TObject);
begin
FrmAltPreco.Show;
end;

procedure TForm4.SpeedButton15Click(Sender: TObject);
begin
FrmConsNfe.Show;
end;

procedure TForm4.SpeedButton21Click(Sender: TObject);
begin
FrmCentroCusto.Show;
end;

procedure TForm4.SpeedButton22Click(Sender: TObject);
begin
FrmCadCONTC.show;
end;

procedure TForm4.SpeedButton24Click(Sender: TObject);
begin
FrmCadGrupo.Show;
end;

procedure TForm4.SpeedButton25Click(Sender: TObject);
begin
FrmCadSubGrupo.Show;
end;

procedure TForm4.ipoTitulo1Click(Sender: TObject);
begin
FrmCadTipoT.Show;
end;

procedure TForm4.Empresa2Click(Sender: TObject);
begin
Form2.Show;
end;

procedure TForm4.ClienteFornecedor2Click(Sender: TObject);
begin
Form10.Show;
end;

procedure TForm4.ProdutoServio2Click(Sender: TObject);
begin
FRMCADPROD.Show;
end;

procedure TForm4.NotaEntrada2Click(Sender: TObject);
begin
Form7.Show;
end;

procedure TForm4.EntradaSintegra1Click(Sender: TObject);
begin
Form82.Show;
end;

procedure TForm4.BaixaTitulo1Click(Sender: TObject);
begin
FrmBaixaTitulo.Show;
end;

procedure TForm4.Movimentodiario1Click(Sender: TObject);
begin
FrmCadMovD.Show;
end;

procedure TForm4.Vendasvendedoras1Click(Sender: TObject);
begin
CadVendDiario.Show;
end;

procedure TForm4.CadastroTitulos1Click(Sender: TObject);
begin
FrmCadTitulos.Show;
end;

procedure TForm4.VariosTitulos1Click(Sender: TObject);
begin
FrmCadTitPa.Show;
end;

procedure TForm4.AlterarPreo1Click(Sender: TObject);
begin
FrmAltPreco.Show;
end;

procedure TForm4.Aprovartitulos11Click(Sender: TObject);
begin
FrmAprovPag.Show;
end;

procedure TForm4.Aprovartitulos21Click(Sender: TObject);
begin
FrmTitulosP.Show;
end;

procedure TForm4.ConsultaNf11Click(Sender: TObject);
begin
FrmConsNfe.Show;
end;

procedure TForm4.ConsultaNf21Click(Sender: TObject);
begin
ConsEntradas.Show;
end;

procedure TForm4.Relatoriovendedora1Click(Sender: TObject);
begin
Form108.show
end;

procedure TForm4.ConsultaNf31Click(Sender: TObject);
begin
Form98.show;
end;

procedure TForm4.Etiqueta3Click(Sender: TObject);
begin
Form73.show;
end;

procedure TForm4.CentrodeCusto2Click(Sender: TObject);
begin
FrmCentroCusto.Show;
end;

procedure TForm4.ContaCorrente2Click(Sender: TObject);
begin
FrmCadCONTC.show;
end;

procedure TForm4.Contador1Click(Sender: TObject);
begin
FrmCadContador.Show;
end;

procedure TForm4.Grupo1Click(Sender: TObject);
begin
FrmCadGrupo.Show;
end;

procedure TForm4.SubGrupo1Click(Sender: TObject);
begin
FrmCadSubGrupo.Show;
end;

procedure TForm4.lanarsaidas1Click(Sender: TObject);
begin
Form83.show;
end;

procedure TForm4.Marca1Click(Sender: TObject);
begin
FRMMARCA.show;
end;

procedure TForm4.RelatoriodeCdiario1Click(Sender: TObject);
begin
RelMovDiario.Show;
end;

procedure TForm4.resClick(Sender: TObject);
begin
RelApuSaidas.show();
end;

end.
