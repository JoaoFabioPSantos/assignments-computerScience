const service = require('../services/gnomeService');


exports.listar = (req, res) => {
  service.listar((err, results) => {
    if (err) return res.status(500).json({ erro: err.message });
    res.json(results);
  });
};

exports.criar = (req, res) => {
  const { name, atribute } = req.body;

  service.criar(name, atribute, (err, result) => {
    if (err) return res.status(400).json({ erro: err.message });

    res.status(201).json(result);
  });
};

exports.salvarFormula = (req, res) => {
  const { gnome_id, descricao, expressao } = req.body;

  service.salvarFormula(gnome_id, descricao, expressao, (err, result) => {
    if (err) return res.status(400).json({ erro: err.message });
    res.status(201).json(result);
  });
};

exports.listarTodasComGnomos = (req, res) => {
  service.listarTodasComGnomos((err, results) => {
    if (err) return res.status(500).json({ erro: err.message });
    res.json(results);
  });
};

exports.listarPorGnomo = (req, res) => {
  const { id } = req.params;

  service.listarPorGnomo(id, (err, results) => {
    if (err) return res.status(500).json({ erro: err.message });
    res.json(results);
  });
};

exports.deletarFormula = (req, res) => {
  const { id } = req.params;

  service.deletarFormula(id, (err, result) => {
    if (err) return res.status(400).json({ erro: err.message });
    res.json({ mensagem: "Fórmula removida com sucesso", dado: result });
  });
};