unit Unit216;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Grids, DBGrids, StdCtrls, Buttons, ExtCtrls, DB, DBTables,
  IBCustomDataSet, IBQuery;

type
  TConsEntradas = class(TForm)
    DBGrid1: TDBGrid;
    Panel1: TPanel;
    Label1: TLabel;
    SpeedButton1: TSpeedButton;
    Edit1: TEdit;
    GroupBox1: TGroupBox;
    RadioButton1: TRadioButton;
    RadioButton2: TRadioButton;
    RadioButton3: TRadioButton;
    RadioButton4: TRadioButton;
    Panel2: TPanel;
    RadioButton5: TRadioButton;
    RadioButton6: TRadioButton;
    RadioButton7: TRadioButton;
    DataSource1: TDataSource;
    SpeedButton2: TSpeedButton;
    SpeedButton3: TSpeedButton;
    Query1: TIBQuery;
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ConsEntradas: TConsEntradas;

implementation

uses Unit2, Unit1;

{$R *.dfm}

procedure TConsEntradas.SpeedButton1Click(Sender: TObject);
begin
   if(RadioButton1.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where DCNUMERO = '+Edit1.Text;
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton2.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where DCSERIE LIKE '''+Edit1.Text+'''';
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton3.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where DCORDEM LIKE '''+Edit1.Text+'''';
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton4.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where DTENTRADA = '''+Edit1.Text+'''';
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton4.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where DTENTRADA = '''+Edit1.Text+'''';
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton5.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where CDFORNECEDOR = '+Edit1.Text;
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
   if(RadioButton6.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select *from NFENTRADAS where NATUREZA = '+Edit1.Text;
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
      if(RadioButton7.Checked = true)then
   BEGIN
    query1.Active := FALSE;
    query1.sql.Text := 'select N.* from NFENTRADAS N , NFENTRADASITENS I where N.DCNUMERO = I.DCNUMERO AND N.DCSERIE = I.DCSERIE AND N.DCORDEM = I.DCORDEM AND I.CDPRODUTO = '+Edit1.Text;
  // SHOWmESSAGE(query1.sql.Text);
    query1.Active := true;
   END;
end;

procedure TConsEntradas.SpeedButton3Click(Sender: TObject);
begin
Close();
end;

end.
