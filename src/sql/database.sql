CREATE TABLE paciente (
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dt_nascimento DATE NOT NULL
);

CREATE TABLE medico (
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    crm VARCHAR(45) NOT NULL
);

CREATE TABLE sigla_formacao(
   ID SERIAL PRIMARY KEY,
   sigla VARCHAR(45) NOT NULL
);

CREATE TABLE responsavel_tecnico(
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    conselho VARCHAR(45) NOT NULL,
    formacao VARCHAR(45) NOT NULL,
    sigla_formacao_id INT NOT NULL,
    FOREIGN KEY (sigla_formacao_id) REFERENCES sigla_formacao (ID)
);

CREATE TABLE especialidade(
    ID SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    observacao VARCHAR(255) NOT NULL
);

CREATE TABLE laboratorio (
     ID SERIAL PRIMARY KEY,
     descricao VARCHAR(255) NOT NULL,
     cnes VARCHAR(45) NOT NULL,
     cnpj VARCHAR(45) NOT NULL,
     crbm VARCHAR(45) NOT NULL,
     nome_fantasia VARCHAR(255) NOT NULL
);

CREATE TABLE responsavel_tecnico_has_laboratorio(
    responsavel_tecnico_id INT NOT NULL,
    laboratorio_id INT NOT NULL,
    FOREIGN KEY (responsavel_tecnico_id) REFERENCES responsavel_tecnico (ID),
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio (ID)
);

CREATE TABLE medico_has_especialidade (
    medico_id INT NOT NULL,
    especialidade_id INT NOT NULL,
    FOREIGN KEY (medico_id) REFERENCES medico (ID),
    FOREIGN KEY (especialidade_id) REFERENCES especialidade (ID)
);

CREATE TABLE endereco (
    ID SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(45) NOT NULL,
    complemento VARCHAR(45) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cep VARCHAR(45) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    laboratorio_id INT NOT NULL,
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio (ID)
);

CREATE TABLE contato (
    ID SERIAL PRIMARY KEY,
    telefone VARCHAR(45) NOT NULL,
    laboratorio_id INT NOT NULL,
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio (ID)
);

CREATE TABLE tipo_exame (
    ID SERIAL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    observacao VARCHAR(45) NOT NULL
);

CREATE TABLE material_exame (
    ID SERIAL PRIMARY KEY,
    material VARCHAR(45) NOT NULL,
    observacao VARCHAR(45) NOT NULL
);

CREATE TABLE unidade_medida (
    ID SERIAL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE habilitacao_exame (
    ID SERIAL PRIMARY KEY,
    observacao VARCHAR(45) NOT NULL,
    custo BIGINT NOT NULL,
    id_laboratorio INT NOT NULL REFERENCES laboratorio(id),
    tipo_exame_id INT NOT NULL REFERENCES tipo_exame(id)
);

CREATE TABLE exame (
    ID SERIAL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    metodo VARCHAR(255) NOT NULL,
    material_exame_id INT NOT NULL REFERENCES laboratorio(id),
    tipo_exame_id INT NOT NULL REFERENCES tipo_exame(id)
);

CREATE TABLE consulta_medica (
     ID SERIAL PRIMARY KEY,
     dt_consulta DATE NOT NULL,
     nm_atendimento VARCHAR(45) NOT NULL,
     paciente_id INT NOT NULL REFERENCES paciente(id),
     medico_id INT NOT NULL REFERENCES medico(id)
);

CREATE TABLE solicitacao_exame (
    ID SERIAL PRIMARY KEY,
    nm_prescrito VARCHAR(45) NOT NULL,
    dt_solicitacao DATE NOT NULL,
    consulta_medica_id INT NOT NULL REFERENCES consulta_medica(id),
    habilitacao_exame_id INT NOT NULL REFERENCES habilitacao_exame(id),
    exame_id INT NOT NULL REFERENCES exame(id)
);

CREATE TABLE laudo (
    ID SERIAL PRIMARY KEY,
    assinatura_digital VARCHAR(45) NOT NULL,
    dt_resultado VARCHAR(45) NOT NULL,
    codigo VARCHAR(45) NOT NULL,
    solicitacao_exame_id INT NOT NULL REFERENCES solicitacao_exame(id)
);

CREATE TABLE composicao_exame (
    ID SERIAL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    unidade_medida_id INT NOT NULL REFERENCES unidade_medida(id)
);

CREATE TABLE valor_referencia_composicao_exame (
    ID SERIAL PRIMARY KEY,
    valor_minimo VARCHAR(45) NOT NULL,
    valor_maximo VARCHAR(45) NOT NULL,
    limitador_minimo VARCHAR(45) NOT NULL,
    limitador_maximo VARCHAR(45) NOT NULL,
    unidade_medida_id INT NOT NULL REFERENCES unidade_medida(id)
);

CREATE TABLE composicao (
    ID SERIAL PRIMARY KEY,
    exame_id INT NOT NULL REFERENCES exame(id),
    composicao_exame_id INT NOT NULL REFERENCES composicao_exame(id),
    valor_referencia_composicao_exame_id INT NOT NULL REFERENCES valor_referencia_composicao_exame(id)
);

CREATE TABLE resultado_exame (
     ID SERIAL PRIMARY KEY,
     dt_exame DATE NOT NULL,
     valor VARCHAR(45) NOT NULL,
     composicao_id INT NOT NULL REFERENCES composicao(id),
     laudo_id INT NOT NULL REFERENCES laudo(id),
);