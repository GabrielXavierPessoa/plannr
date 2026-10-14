export type Service = {
  slug: string;
  name: string;
  description: string;
  price: number;
  durationMinutes: number;
  illustration: "barber" | "manicure" | "massage";
};

// Conteúdo provisório para demonstração; ainda não vem do backend.
export const services: Service[] = [
  {
    slug: "barbeiro",
    name: "Barbeiro",
    description: "Corte de cabelo e barba com profissional experiente.",
    price: 45,
    durationMinutes: 45,
    illustration: "barber",
  },
  {
    slug: "manicure",
    name: "Manicure",
    description: "Tratamento completo para unhas com produtos de qualidade.",
    price: 35,
    durationMinutes: 60,
    illustration: "manicure",
  },
  {
    slug: "massagem",
    name: "Massagem",
    description: "Sessão de massagem relaxante para aliviar o estresse.",
    price: 90,
    durationMinutes: 50,
    illustration: "massage",
  },
];

export const serviceCurrency = new Intl.NumberFormat("pt-BR", {
  style: "currency",
  currency: "BRL",
});

export function getServiceBySlug(slug: string) {
  return services.find((service) => service.slug === slug);
}
