import { http } from "./http.js";

export function listarUnidades() {
  return http("/unidades");
}

export function cadastrarUnidade(unidade) {
  return http("/unidades", {
    method: "POST",
    body: JSON.stringify(unidade),
  });
}

export function atualizarUnidade(id, unidade) {
  return http(`/unidades/${id}`, {
    method: "PUT",
    body: JSON.stringify(unidade),
  });
}

export function desativarUnidade(id) {
  return http(`/unidades/${id}/desativar`, {
    method: "PATCH",
  });
}