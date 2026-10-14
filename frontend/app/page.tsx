import ServiceCard from "@/components/ServiceCard";
import Header from "@/components/Header";

// Dados provisórios para demonstração; ainda não vêm do banco de dados.
const services = [
  {
    name: "Barbeiro",
    description: "Corte de cabelo e barba com profissional experiente.",
    price: 45,
    durationMinutes: 45,
    illustration: "barber" as const,
  },
  {
    name: "Manicure",
    description: "Tratamento completo para unhas com produtos de qualidade.",
    price: 35,
    durationMinutes: 60,
    illustration: "manicure" as const,
  },
  {
    name: "Massagem",
    description: "Sessão de massagem relaxante para aliviar o estresse.",
    price: 90,
    durationMinutes: 50,
    illustration: "massage" as const,
  },
];

export default function Home() {
  return (
    <div className="min-h-screen bg-white font-sans text-[#0F172A]">
      <Header />

      <main>
        <section className="flex max-w-[760px] flex-col gap-6 px-6 pt-20 pb-14 md:px-20">
          <h1 className="m-0 text-[52px] leading-[1.1] font-bold">
            Agende seu horário de forma simples.
          </h1>
          <p className="m-0 text-xl leading-[1.5] text-[#475569]">
            Escolha o serviço, o dia e o horário. Sem ligações, sem espera.
          </p>
          <div>
            <a
              href="#"
              className="inline-block rounded-lg bg-[#1D4ED8] px-8 py-4 font-bold text-white no-underline transition duration-200 ease-out hover:bg-[#1E40AF] hover:shadow-md active:scale-[0.98]"
            >
              Agendar agora
            </a>
          </div>
        </section>

        <section
          aria-labelledby="services-heading"
          className="flex flex-col gap-6 px-6 pt-0 pb-20 md:px-20"
        >
          <h2 id="services-heading" className="m-0 text-[28px] font-bold">
            Nossos serviços
          </h2>
          <div className="grid grid-cols-1 gap-6 md:grid-cols-3">
            {services.map((service) => (
              <ServiceCard key={service.name} service={service} />
            ))}
          </div>
          <div>
            <button>
              Clique aqui para
              <a href="#" className="text-[#1D4ED8] hover:text-[#1E40AF] underline padding-left-1.5">
                 ver mais
              </a>
            </button>
          </div>
        </section>
      </main>
    </div>
  );
}
