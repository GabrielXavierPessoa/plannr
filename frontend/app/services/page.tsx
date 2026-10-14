import Header from "@/components/Header";
import ServiceSelection from "./ServiceSelection";
import styles from "./services.module.css";

export default function ServicesPage() {
  return (
    <div className="min-h-screen bg-white font-sans text-[#0F172A]">
      <Header activePage="services" />
      <main className={styles.page}>
        <ServiceSelection />
      </main>
    </div>
  );
}
