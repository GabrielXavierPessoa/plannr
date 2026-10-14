import ServiceCard from "@/components/ServiceCard";
import Header from "@/components/Header";
import Link from "next/link";
import { services } from "@/lib/services";

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
            <Link
              href="/services"
              className="inline-block rounded-lg bg-[#1D4ED8] px-8 py-4 font-bold text-white no-underline transition duration-200 ease-out hover:bg-[#1E40AF] hover:shadow-md active:scale-[0.98]"
            >
              Agendar agora
            </Link>
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
          <Link
            href="/services"
            className="w-fit text-[#1D4ED8] underline hover:text-[#1E40AF]"
          >
            Ver todos os serviços
          </Link>
        </section>
      </main>
    </div>
  );
}
