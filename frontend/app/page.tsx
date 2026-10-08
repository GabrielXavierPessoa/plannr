import Header from "@/components/Header";

const services = ["[Serviço 1]", "[Serviço 2]", "[Serviço 3]"];

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
              className="inline-block rounded-lg bg-[#1D4ED8] px-8 py-4 font-bold text-white no-underline"
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
                key={service}
                className="flex flex-col gap-3 rounded-xl border border-[#C7D5F5] bg-[#EFF4FF] p-7"
              >
                <div
                  aria-hidden="true"
                  className="h-12 w-12 rounded-full border-2 border-[#1D4ED8]"
                />
                <h3 className="m-0 text-[22px] font-bold">{service}</h3>
                <p className="m-0 text-[#475569]">[Descrição curta]</p>
              </article>
            ))}
          </div>
        </section>
      </main>
    </div>
  );
}
