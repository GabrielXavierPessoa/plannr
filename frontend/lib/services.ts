export type Service = {
  name: string;
  description: string;
  price: number;
  durationMinutes: number;
};

// Conteúdo provisório para demonstração; ainda não vem do backend.
export const services: Service[] = [
  {
    name: "Barbeiro",
    description: "Corte de cabelo e barba com profissional experiente.",
    price: 45,
    durationMinutes: 45,
  },
  {
    name: "Manicure",
    description: "Tratamento completo para unhas com produtos de qualidade.",
    price: 35,
    durationMinutes: 60,
  },
  {
    name: "Massagem",
    description: "Sessão de massagem relaxante para aliviar o estresse.",
    price: 90,
    durationMinutes: 50,
  },
];

export const serviceCurrency = new Intl.NumberFormat("pt-BR", {
  style: "currency",
  currency: "BRL",
});

