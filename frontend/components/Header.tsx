export default function Header() {
  return (
    <header className="flex items-center justify-between border-b border-slate-200 bg-white px-6 py-5 md:px-20">
      <div className="flex items-center gap-3 text-xl font-bold text-slate-900">
        <svg
          aria-hidden="true"
          className="h-9 w-9"
          viewBox="0 0 56 56"
          fill="none"
        >
          <rect width="56" height="56" rx="14" fill="#1D4ED8" />
          <path
            d="M20 43V15h11a8.5 8.5 0 0 1 0 17H20"
            stroke="white"
            strokeWidth="5"
            strokeLinecap="round"
            strokeLinejoin="round"
          />
          <circle cx="43" cy="14" r="4.5" fill="#F59E0B" />
        </svg>
        <span>Plannr</span>
      </div>

      <nav aria-label="Navegação principal" className="flex items-center gap-8 text-base">
        <a href="#" className="text-slate-900 no-underline">
          Início
        </a>
        <a href="#" className="text-slate-900 no-underline">
          Serviços
        </a>
        <a href="#" className="text-slate-900 no-underline">
          Meus agendamentos
        </a>
        <a href="#" className="text-slate-900 no-underline">
          Entrar
        </a>
      </nav>
    </header>
  );
}
