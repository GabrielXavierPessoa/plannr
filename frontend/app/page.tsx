import Header from "@/components/Header";

const services = [
  {
    name: "Barbeiro",
    description: "Corte de cabelo e barba com profissional experiente.",
  },
  {
    name: "Manicure",
    description: "Tratamento completo para unhas com produtos de qualidade.",
  },
  {
    name: "Massagem",
    description: "Sessão de massagem relaxante para aliviar o estresse.",
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
              <article
                key={service.name}
                className="flex flex-col gap-3 rounded-xl border border-[#C7D5F5] bg-[#EFF4FF] p-7 transition duration-200 ease-out hover:-translate-y-0.5 hover:border-[#A9BFEF] hover:shadow-sm"
              >
                <div
                  aria-hidden="true"
                  className="flex h-12 w-12 items-center justify-center rounded-full border-2 border-[#1D4ED8] text-[#1D4ED8]"
                >
                  {service.name === "Barbeiro" ? (
                    <svg
                      viewBox="0 0 24 24"
                      className="h-7 w-7"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="1.8"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                    >
                      <circle cx="6" cy="6" r="2.5" />
                      <circle cx="6" cy="18" r="2.5" />
                      <path d="m8 7.5 11 11.5" />
                      <path d="M8 16.5 19 5" />
                    </svg>
                  ) : service.name === "Manicure" ? (
                    <svg
                      viewBox="0 0 24 24"
                      className="h-7 w-7"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="1.8"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                    >
                      <path d="M8 3.5c1.5 0 2.5 1.2 2.5 2.7v6.2" />
                      <path d="M10.5 12.4V7.1c0-1.2.8-2.1 1.9-2.1s1.9.9 1.9 2.1v5.3" />
                      <path d="M14.3 12V8.4c0-1.1.8-1.9 1.8-1.9s1.8.8 1.8 1.9v5" />
                      <path d="M17.9 13.2v-2.1c0-1 .7-1.7 1.6-1.7s1.6.7 1.6 1.7v3.6c0 4.2-2.8 6.8-7 6.8h-1.2c-2.6 0-4.8-1.3-6.1-3.5L4.5 14.4c-.5-.9-.2-2 .7-2.5.9-.5 2-.2 2.5.7l1.1 1.8" />
                    </svg>
                  ) : (
                    <svg
                      viewBox="0 0 24 24"
                      className="h-7 w-7"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="1.8"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                    >
                      <path d="M7 8.5c1.5-2.2 4.1-3.2 6.4-2.2 1.2.5 2.1 1.4 2.6 2.6" />
                      <path d="M4 12c2.3-.7 4.4-.2 5.9 1.4 1.2 1.3 1.8 3 1.7 4.8" />
                      <path d="M13.5 10.5c1.5-1.1 3.4-1.1 4.8 0 1.3 1 2 2.6 2 4.2" />
                      <path d="M6.5 18.5c1.6 1.3 3.6 2 5.7 2 3.6 0 6.4-2.1 7.5-5.2" />
                    </svg>
                  )}
                </div>
                <h3 className="m-0 text-[22px] font-bold">{service.name}</h3>
                <p className="m-0 text-[#475569]">{service.description}</p>
              </article>
            ))}
          </div>
        </section>
      </main>
    </div>
  );
}
